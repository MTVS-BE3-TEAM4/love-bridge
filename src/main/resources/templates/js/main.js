    const open = document.querySelector('.menu');
    const close = document.querySelector('.close');
    var tl = gsap.timeline({ defaults: { duration: 0.6, ease: 'expo.inOut' } }); // duration을 0.6초로 변경

    open.addEventListener('click', () => {
        if (tl.reversed()) {
            tl.play();
            
            
        } else {
            tl.to('nav', { right: 0, duration: 0.4 }) // 각각의 애니메이션 스텝의 duration을 더 짧게 설정
                .to('nav', { height: '100vh', duration: 0.4 }, '-=.1')
                .to('.menu', { opacity: 0, pointerEvents: 'all', duration: 0.3 }, "-=.4")
                .to('nav ul li a', { opacity: 1, pointerEvents: 'all', stagger: 0.2 }, '-=.4') // stagger 값을 0.1로 줄임
                .to('.close', { opacity: 1, pointerEvents: 'all', duration: 0.4 }, "-=.4") // duration을 0.3초로 변경
                .to('nav h2', { opacity: 1, duration: 0.4 }, '-=0.6'); // duration을 0.4초로 변경
        }
    });

    close.addEventListener('click', () => {
        tl.reverse();
    });

    gsap.registerPlugin(ScrollTrigger);

    const textElements = gsap.utils.toArray('.hover-box');

    textElements.forEach(text => {
        gsap.to(text, {
            backgroundSize: '100%',
            ease: 'none',
            scrollTrigger: {
            trigger: text,
            start: 'center 90%',
            end: 'center 90%',
            scrub: true,
            },
        });
    });

var sakura = new Sakura('.sakura-bg', {
    colors: [
    {
        gradientColorStart: 'rgba(255, 183, 197, 0.9)',
        gradientColorEnd: 'rgba(255, 197, 208, 0.9)',
        gradientColorDegree: 120,
    },
    {
        gradientColorStart: 'rgba(255,189,189)',
        gradientColorEnd: 'rgba(227,170,181)',
        gradientColorDegree: 120,
    },
    {
        gradientColorStart: 'rgba(212,152,163)',
        gradientColorEnd: 'rgba(242,185,196)',
        gradientColorDegree: 120,
    },
    ],
    delay: 200
});

!function(e,t,a){function n(){c(".heart{width: 11%;height: 11%;position: fixed;background: #f00;transform: rotate(45deg);-webkit-transform: rotate(45deg);-moz-transform: rotate(45deg);}.heart:after,.heart:before{content: '';width: inherit;height: inherit;background: inherit;border-radius: 50%;-webkit-border-radius: 50%;-moz-border-radius: 50%;position: fixed;}.heart:after{top: -5px;}.heart:before{left: -5px;}"),o(),r()}function r(){for(var e=0;e<d.length;e++)d[e].alpha<=0?(t.body.removeChild(d[e].el),d.splice(e,1)):(d[e].y--,d[e].scale+=.004,d[e].alpha-=.013,d[e].el.style.cssText="left:"+d[e].x+"px;top:"+d[e].y+"px;opacity:"+d[e].alpha+";transform:scale("+d[e].scale+","+d[e].scale+") rotate(45deg);background:"+d[e].color+";z-index:99999");requestAnimationFrame(r)}function o(){var t="function"==typeof e.onclick&&e.onclick;e.onclick=function(e){t&&t(),i(e)}}function i(e){var a=t.createElement("div");a.className="heart",d.push({el:a,x:e.clientX-5,y:e.clientY-5,scale:1,alpha:1,color:s()}),t.body.appendChild(a)}function c(e){var a=t.createElement("style");a.type="text/css";try{a.appendChild(t.createTextNode(e))}catch(t){a.styleSheet.cssText=e}t.getElementsByTagName("head")[0].appendChild(a)}function s(){return"rgb("+~~(255*Math.random())+","+~~(255*Math.random())+","+~~(255*Math.random())+")"}var d=[];e.requestAnimationFrame=function(){return e.requestAnimationFrame||e.webkitRequestAnimationFrame||e.mozRequestAnimationFrame||e.oRequestAnimationFrame||e.msRequestAnimationFrame||function(e){setTimeout(e,1e3/60)}}(),n()}(window,document);
