package ru.rsreu.toy.shop.service

import com.mongodb.BasicDBObject
import com.mongodb.gridfs.GridFS
import org.bson.types.ObjectId
import org.springframework.core.io.InputStreamResource
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.gridfs.GridFsOperations
import org.springframework.data.mongodb.gridfs.GridFsTemplate
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import ru.rsreu.toy.shop.dto.ProductDto
import ru.rsreu.toy.shop.entity.Product
import ru.rsreu.toy.shop.repository.ProductRepository

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val gridFsTemplate: GridFsTemplate,
    private val operations: GridFsOperations
) {
    fun getProducts(sort: String): List<ProductDto> {
        val products = productRepository.findAll().map { convertToProductDto(it) }
        return when (sort) {
            "name" -> products.sortedBy { it.title }
            "priceAsc" -> products.sortedBy { it.price }
            "priceDesc" -> products.sortedByDescending { it.price }
            else -> products
        }
    }

    private fun convertToProductDto(entity: Product): ProductDto {
        return ProductDto(
            id = entity.id?.toHexString(),
            title = entity.title,
            description = entity.description,
            imgUrl = entity.imgUrl,
            price = entity.price,
            vendorCode = entity.vendorCode
        )
    }

    fun deleteProduct(id: String) {
        //ToDo удалять изображения
        val objectId = ObjectId(id)
        productRepository.deleteById(objectId)
    }

    fun createProduct(product: ProductDto) {
        val entity = Product(
            id = product.id?.toObjectId(),
            title = product.title,
            description = product.description,
            imgUrl = product.imgUrl,
            price = product.price,
            vendorCode = product.vendorCode
        )

        productRepository.save(entity)
    }

    fun findProduct(id: String): ProductDto? {
        if (ObjectId.isValid(id)) {
            val objectId = ObjectId(id)
            val product = productRepository.findByIdOrNull(objectId)
            if (product != null) {
                val productDto = convertToProductDto(product)
                return productDto
            } else {
                return null
            }
        } else {
            return null
        }
    }

    fun saveImg(img: MultipartFile): String {
        val inputStream=img.inputStream
        val metadata = BasicDBObject()
        metadata["contentType"] = img.contentType
        val id= gridFsTemplate.store(inputStream, img.name, metadata)
        return "/img/${id.toHexString()}"
    }

    fun getImg(id:String):ResponseEntity<InputStreamResource>{
        val img=gridFsTemplate.findOne(Query(Criteria.where("_id").`is`(id)))
        return ResponseEntity.ok()
            .contentLength(img.length)
            .contentType(MediaType.parseMediaType(img.metadata.getString("contentType")))
            .body(InputStreamResource(operations.getResource(img).inputStream))
    }

}

fun String.toObjectId(): ObjectId? {
    if (ObjectId.isValid(this)) {
        return ObjectId(this)
    } else {
        return null
    }
}
