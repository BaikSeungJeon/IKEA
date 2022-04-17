$.ajax({

    url: "ProductJsonList.do",
    success: function (resultData) {

        console.log(resultData.galleryList);
        const galleryList = resultData.galleryList;
        $("#productList").append(`<ul class="list"></ul>`);

        $.each(galleryList, function (i, item) {
            //var categories = item.category.replace(/,/gi, ' ');
            console.log("item",item);

            
            $("#productList ul").append(`
                                    
                    <li class="item ${item.categoryCode}" data-no=${item.no}>
                        <div class="imgBox">
                            <img src="${item.productImage}">
                        </div>
                        <div class="info">
                            <h2>제품이름:${item.productName}</h2>
                            <p>가격:${item.productPrice}</p>
                            <p>설명:${item.productDesc} </p>
                        </div>
                    </li>`)

        
        });
    }

});