

(function () {
    function includeHtml(callback) {
        const includeTarget = document.querySelectorAll('.includeJs');
        let count = 0;

        function includeComplete() {
            count++;
            if (count === includeTarget.length) {
                // 모든 include가 완료된 후에 실행할 코드를 여기에 추가
                callback();
            }
        }

        includeTarget.forEach(function (el) {
            const targetFile = el.dataset.includeFile;

            if (targetFile) {
                let xhttp = new XMLHttpRequest();

                xhttp.onreadystatechange = function () {
                    if (this.readyState === XMLHttpRequest.DONE) {
                        if (this.status === 200) {
                            el.innerHTML = this.responseText;
                            includeComplete();
                        } else if (this.status === 404) {
                            el.innerHTML = 'include not found.';
                            includeComplete();
                        }
                    }
                };

                xhttp.open('GET', targetFile, true);
                xhttp.send();
            }
        });
    }

    // 다른 JavaScript 파일 로드 함수
    function loadOtherScript() {
        var scriptElement = document.createElement('script');
        var scriptElement2 = document.createElement('script');
        var scriptElement3 = document.createElement('script');
        // scriptElement.src = 'otherScript.js';
        scriptElement.src = '../js/sakura.js'
        scriptElement2.src = '../js/main.js'
        scriptElement3.src = '../js/sakura.js'
        document.head.appendChild(scriptElement);
        document.head.appendChild(scriptElement2);
        document.head.appendChild(scriptElement3);
    }
    

    // 비동기 문제 해결을 위해 콜백 함수 사용
    includeHtml(function () {
        // 공통 HTML이 모두 로드된 후에 실행될 코드를 여기에 추가
        // 예: 다른 JavaScript 파일 로드
        loadOtherScript();
        // 추가적으로 실행할 코드가 있다면 여기에 추가
    });
})();