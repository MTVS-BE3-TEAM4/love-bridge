// Game관련 JavaScript

document.querySelector('.attendacetransferButton')
    .addEventListener('click', function() {
        const button = this;
        button.classList.add('clicked');
        setTimeout(function() {
            button.classList.remove('clicked');
        }, 200);
    });

let F_character = document.getElementById("F_character");
let M_character = document.getElementById("M_character");

let F_position = 0;
let M_position = 0;

const WinnerOkDialog = document.getElementById("WinnerOK");

const WANTTEXT_M = document.getElementById("MText");
const WANTTEXT_F = document.getElementById("FText");
const WantBtn_M = document.getElementById("WantBtn_M");
const WantBtn_F = document.getElementById("WantBtn_F");
const WantEntire_F = document.getElementById("WantInputController_F");
const WantEntire_M = document.getElementById("WantInputController_M");
const resultList = document.getElementById("resultList");
const F_btn = document.getElementById("F_btn");
const M_btn = document.getElementById("M_btn");
let mission_test = document.getElementById("mission-test");



// 여자
document.addEventListener("DOMContentLoaded", function() {

    fetch('/Game/MoveGameApi', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(data => {
            console.log(data);
            // 데이터를 받아와서 화면에 표시하거나 필요한 처리를 수행
            const attendCnt = data.attendCnt;
            let partnerAttendCnt;
            const mission = data.mission;
            let partnerMission;
            F_character.style.left = F_position = attendCnt + "%";
            console.log("F_character.style.left 전 :: " + F_character.style.left);
        })
        .catch(error => {
            console.error('Error:', error);
        });

    document.getElementById("F_btn").addEventListener("click", function() {
        console.log("F_position 현재 :: " + F_position);
        if (F_position < 30) {
            F_position++;
            console.log("F_position ++ :" + F_position);
            F_character.style.left = (F_position * 1) + "%"; // 변수 사용
            console.log("F_character.style.left 후 :: " + F_character.style.left);
            if (F_position === 30) {
                sendPosition(F_position, "F", "Win_F");
                document.getElementById("F_heart").style.display = "flex";
                WinnerOkDialog.textContent = " 여자친구분이 이겼어요.";
            } else {
                sendPosition(F_position, "F", "NotWinner");
            }
        }
    });
});


// 남자
document.getElementById("M_btn").addEventListener("click", function() {

    if (M_position < 30) {
        M_position++;
        M_character.style.right = (M_position * 1) + "%";
        if (M_position === 30) {
            sendPosition(M_position, "M", "Win_M");
            WinnerOkDialog.textContent = "남자친구분이 이겼어요.";
            document.getElementById("M_heart").style.display = "flex";
        } else {
            sendPosition(M_position, "M", "NotWinner");
        }
    }
});

document.getElementById("M_btn").addEventListener("click",
    () => {
        const myModal = new bootstrap.Modal(document.getElementById('attendanceModal'), {
            keyboard: false
        });
        myModal.show();
    });

document.addEventListener('DOMContentLoaded', function() {
    const attendanceModal = new bootstrap.Modal(document.getElementById('attendanceModal'), {
        keyboard: false
    });

    document.getElementById("F_btn").addEventListener("click", () => {
        attendanceModal.show();
    });

    document.getElementById("M_btn").addEventListener("click", () => {
        attendanceModal.show();
    });

    document.getElementById('confirmButton').addEventListener('click', () => {
        attendanceModal.hide();
        removeModalBackdrop();
    });

    document.addEventListener("keydown", (event) => {
        if (event.key === "Enter") {
            attendanceModal.hide();
            removeModalBackdrop();
        }
    });

    function removeModalBackdrop() {
        const backdrops = document.getElementsByClassName('modal-backdrop');
        while (backdrops.length > 0) {
            backdrops[0].parentNode.removeChild(backdrops[0]);
        }
    }
});



const DescriptionModal = new bootstrap.Modal(document.getElementById("DescriptionModal"),{
    keyboard:false
})

//도움말 클릭시 모달창 표시
document.getElementById("DescriptionButton").addEventListener("click",
    ()=>{
        DescriptionModal.show();
    })

document.getElementById("DescriptionCloseButton").addEventListener("click",
    ()=>{
        DescriptionModal.hide();
    })

document.addEventListener("keydown", (event) => {
    if (event.key === "Enter") {
        DescriptionModal.hide();
    }
});

function updateTime() {
    const now = new Date();
    const hours = String(now.getHours()).padStart(2, '0');
    const minutes = String(now.getMinutes()).padStart(2, '0');
    const seconds = String(now.getSeconds()).padStart(2, '0');
    const currentTime = `${hours}:${minutes}:${seconds}`;

    document.querySelector('.Time').textContent = currentTime;
}
setInterval(updateTime, 1000);
updateTime();

document.addEventListener("DOMContentLoaded", () => {

    WantBtn_M.addEventListener("click", () => {
        if (WANTTEXT_M.value !== "") {
            WantEntire_M.classList.add("hidden");
            sendWish(WANTTEXT_F.value,WANTTEXT_M.value);
        }
    });

    WantBtn_F.addEventListener("click", () => {
        if (WANTTEXT_F.value !== "") {
            WantEntire_F.classList.add("hidden");
            sendWish(WANTTEXT_F.value,WANTTEXT_M.value);
        }

    });

});

const sendPosition = (position, gender, winner) => {
    fetch('/Game/MoveGame', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            'cnt': position,
            'gender': gender,
            'winner': winner,
        }).toString()
    })
        .then(response => response.text())
        .then(data => {

        })
        .catch(error => {
            console.error('Error:', error);
        });
};

const sendWish = (fwish, mwish) => {
    console.log("fwish ::" + fwish)
    console.log("mwish ::" + mwish)
    fetch('/Game/Wish', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            'fwish': fwish,
            'mwish': mwish
        }).toString()
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById("mission-test").innerText = data.mission;
        })
        .catch(error => {
            console.error('Error:', error);
        });
};
