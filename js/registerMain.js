$(document).on('ready', function() {
   
    const inputText = $(".input");
    
    inputText.on("focusin", function() {

        $(this).prev().addClass("focus-visible");
        $(this).next().addClass("redText");
        $(this).addClass("focus");
    });

    inputText.on("focusout", function() {

        $(this).removeClass("focus");

        if($(this).val().trim()===""){
            $(this).val("");
            $(this).prev().removeClass("focus-visible");
            $(this).next().removeClass("hide")
        } else {
            $(this).next().addClass("hide")
        }
    });


    const postBtn = $(".search-btn");

    postBtn.on("click", function(){

        new daum.Postcode({
    
            oncomplete: function(data) {
                
                var fullAddr = '';
                var extraAddr = ''; 
                
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }
                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('address').value = fullAddr;
                document.getElementById('address2').focus(); // 커서를 상세주소 필드로 이동한다.
            }
        }).open();
    });


    const checkBox = $("#news-all");
    const checkBoxSub = $(".news-checkbox");
    
    checkBox.on("click", function() {
        var checked = $('#news-all').is(':checked');
        if(checked) {
            $(".news-checkbox").prop('checked', true);
        } else {
            $(".news-checkbox").prop('checked', false);
        }
    });

    checkBoxSub.on("click", function() {
        var checked = $(this).is(':checked');
        var checkedSub = $(this).siblings().is(':checked');
        if(checked) {
            $("#news-all").prop('checked', true);
        } else {
            if(checkedSub) {
                $(this).prop('checked', false);
            } else {
                $("#news-all").prop('checked', false);
            }
        }
    });


    const pw = $(".input3"); // 비밀번호
    const pwCheck = $(".input4"); // 비밀번호 확인

    $("#submit-btn").on("click", function() {
        if( pw.val() !== pwCheck.val() ) {
            alert("비밀번호가 틀려용");
        } else {
            alert("비밀번호가 맞아용");
        }
    })
});
