package ru.rsreu.toy.shop.service

import com.mongodb.BasicDBObject
import org.bson.types.ObjectId
import org.springframework.core.io.InputStreamResource
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.gridfs.GridFsOperations
import org.springframework.data.mongodb.gridfs.GridFsTemplate
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class ImageService (
    private val gridFsTemplate: GridFsTemplate,
    private val operations: GridFsOperations
){
    fun saveImg(img: MultipartFile): ObjectId {
        val inputStream=img.inputStream
        val metadata = BasicDBObject()
        metadata["contentType"] = img.contentType
        val id= gridFsTemplate.store(inputStream, img.name, metadata)
        return id
    }

    fun getImg(id:String): ResponseEntity<InputStreamResource> {
        val img=gridFsTemplate.findOne(Query(Criteria.where("_id").`is`(id)))
        return ResponseEntity.ok()
            .contentLength(img.length)
            .contentType(MediaType.parseMediaType(img.metadata.getString("contentType")))
            .body(InputStreamResource(operations.getResource(img).inputStream))
    }

    fun deleteImg(id: ObjectId) {
        gridFsTemplate.delete(Query(Criteria.where("_id").`is`(id)))
    }
}