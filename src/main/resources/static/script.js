let testProducts = [
    {
        title: "Мишка",
        imgUrl: "img/Мишка.jpg",
        description: "Милый плюшевый мишка станет лучшим другом вашему ребенку.",
        vendorCode: "023498",
        price: 1700
    },
    {
        title: "Пикачу",
        imgUrl: "img/Пикачу.jpg",
        description: "Детектив Пикачу поможет найти сладости и конечно же кофе.",
        vendorCode: "190384",
        price: 987
    },
    {
        title: "Пингвинёнок",
        imgUrl: "img/Пингвинёнок.jpg",
        description: "Мягкий пингвинёнок скрасит холодные и грустные вечера.",
        vendorCode: "193278",
        price: 1500
    }
];

function testFill(){
    fillProducts(testProducts)
}

window.onload = getProducts;
// window.onload=testFill;

function fillProducts(products) {
    let box = $("#products");
    let productTemplateHtml = $("#product").html();
    let productTemplate = _.template(productTemplateHtml);

    for(let i=0; i<products.length; i++) {
        let filledTemplate = productTemplate(products[i]);
        box.append(filledTemplate);
    }
}

function onError() {
    console.log("Fail")
}

function getProducts() {
    $.ajax({
        type:'GET',
        url: '/products',
        // contentType: 'application/json'
        success: fillProducts,
        error: onError
    })
}

function deleteProduct(id) {
    clear()
}

function clear() {
    let box = $("#products");
    box.empty()
}