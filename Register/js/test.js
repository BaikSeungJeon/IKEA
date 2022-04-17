$(document).on('ready', function() {
    
    // 글자 상,하 애니메이션 등장
    var t1 = gsap.timeline();
    t1.to(".down", {duration: 1, y: 80}, "+=0.7");
    $(".down").fadeIn(2000);
    t1.to(".up", {duration: 1, y: -80}, "+=1");
    function upFade(){
        $(".up").fadeIn(2000);
    }
    var timer = setTimeout(upFade, 2000);
    timer;

    // 이벤트 슬라이드
    $(".vertical-center").slick({
        infinite: true,
        slidesToShow: 3,
        slidesToScroll: 3,
        dots: true
    });

    // 모달창 떨어지는 동작
    $(".modal_test").click(function(e){
        e.preventDefault();
        $("#popup").fadeIn();
        gsap.to(".modal", {duration: 1, y: 900});
        $(".modal>button").click(function(){
            $("#popup").fadeOut();
            gsap.to(".modal", {duration: 1, y: -900});
        });
    });

    // 상품 호버 효과
    const b_circle = document.getElementById('b_circle');
    b_circle.addEventListener('mouseover',function(e){
        e.preventDefault();
        $(".hover_testbox").stop().fadeIn();
    });
    b_circle.addEventListener('mouseout',function(e){
        e.preventDefault();
        $(".hover_testbox").stop().fadeOut();
    });
});

