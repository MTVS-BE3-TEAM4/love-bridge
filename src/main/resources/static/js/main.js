
    const open = document.querySelector('.menu');
    const close = document.querySelector('.close');
    const headerWrap = document.querySelector('.header');
    var tl = gsap.timeline({ defaults: { duration: 0.6, ease: 'expo.inOut' } }); // duration을 0.6초로 변경

    open.addEventListener('click', () => {

        if (tl.reversed()) {
            tl.play();


        } else {
            tl.to('.menu', { opacity: 0, display: 'none', pointerEvents: 'all', duration: 0.2 })
                .to('nav', { top: 0, display: 'flex', duration: 0.2 }) // 각각의 애니메이션 스텝의 duration을 더 짧게 설정
                .to('nav', { height: '100vh', duration: 0.2 }, '-=.1')
                .to('.close', { opacity: 1, pointerEvents: 'all', duration: 0.2 })// duration을 0.3초로 변경
                .to('nav h2', { opacity: 1, pointerEvents: 'all', duration: 0.2 }) // duration을 0.4초로 변경
                .to('nav ul li a', { opacity: 1, pointerEvents: 'all', stagger: 0.1 }); // stagger 값을 0.1로 줄임


        }

        headerWrap.classList.add('open');

    });

    close.addEventListener('click', () => {
        headerWrap.classList.remove('open');
        tl.reverse();
    })


    // gsap.registerPlugin(ScrollTrigger);

    // const textElements = gsap.utils.toArray('.hover-box');

    // textElements.forEach(text => {
    //     gsap.to(text, {
    //         backgroundSize: '100%',
    //         ease: 'none',
    //         scrollTrigger: {
    //         trigger: text,
    //         start: 'center 90%',
    //         end: 'center 90%',
    //         scrub: true,
    //         },
    //     });
    // });

    // gsap.registerPlugin(ScrollTrigger);

// ScrollTrigger.defaults({
//   toggleActions: "play reset play reset",
//   markers: false
// });
//
// document.querySelectorAll(".text").forEach((text, index) => {
//   const targetID = text.dataset.target;
//   const target = document.querySelector(`#${targetID}`);
//   gsap.to(text, {
//     autoAlpha: 1,
//     duration: 0.5,
//     // ease: "power4.inOut",
//     scrollTrigger: {
//       trigger: target,
//       start: "top center",
//       end: "bottom center"
//     }
//   });
// });

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

function sendPost() {
    let headerForm = document.createElement('form');

    headerForm.setAttribute('method', 'post');
    headerForm.setAttribute('action', '/member/logout');
    document.body.appendChild(headerForm);
    headerForm.submit();
}


