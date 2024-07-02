    const open = document.querySelector('.menu');
    const close = document.querySelector('.close');
    var tl = gsap.timeline({ defaults: { duration: 0.7, ease: 'expo.inOut' } }); // duration을 0.6초로 변경

    open.addEventListener('click', () => {
        if (tl.reversed()) {
            tl.play();
        } else {
            tl.to('nav', { right: 0, duration: 0.5 }) // 각각의 애니메이션 스텝의 duration을 더 짧게 설정
                .to('nav', { height: '100vh', duration: 0.5 }, '-=.1')
                .to('nav ul li a', { opacity: 1, pointerEvents: 'all', stagger: 0.2 }, '-=.4') // stagger 값을 0.1로 줄임
                .to('.close', { opacity: 1, pointerEvents: 'all', duration: 0.4 }, "-=.4") // duration을 0.3초로 변경
                .to('nav h2', { opacity: 1, duration: 0.5 }, '-=0.6'); // duration을 0.4초로 변경
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

var sakura = new Sakura('body', {
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