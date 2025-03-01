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
const F_btn = document.getElementById("F_btn");
const M_btn = document.getElementById("M_btn");

const attendanceModal = new bootstrap.Modal(document.getElementById('attendanceModal'), {
    keyboard: false
});

const gameWrap = document.querySelector('.GameWrap');
const Mbtn = document.querySelector('#M_btn');
const Fbtn = document.querySelector('#F_btn');
const modalConfirmBtn = document.querySelector('#attendanceModal #confirmButton');

const myWishBtn = document.getElementById("WantBtn_F");
const partnerWishBtn = document.getElementById("WantBtn_M");

const myWishText = document.getElementById("FText");
const partnerWishText = document.getElementById("MText");

const myWishController = document.getElementById("WantInputController_F");
const partnerWishController = document.getElementById("WantInputController_M");
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
            const myAttendCnt = data.myAttendCnt;
            const partnerAttendCnt = data.partnerAttendCnt;
            let myPositionF = (F_position = myAttendCnt);
            let myPositionM = (M_position = partnerAttendCnt);
            F_character.style.left = myPositionF = myAttendCnt + '%';
            M_character.style.right =  myPositionM = partnerAttendCnt + '%';
        })
        .catch(error => {
            console.error('Error:', error);
        });


    if(gameWrap.contains(Mbtn)) {
        M_btn.addEventListener('click', () => {
            if (M_position < 30) {

                M_position++;
              
                console.log(M_position);
                M_character.style.right = (M_position * 1) + "%";
                if (M_position === 30) {
                    sendPosition(M_position, "M", "Win_M");
                    WinnerOkDialog.textContent = "남자친구분이 이겼어요.";
                    document.getElementById("M_heart").style.display = "flex";

                } else {
                    sendPosition(M_position, "M", "NotWinner");
                }
            }

            attendanceModal.show();
        })
    } else if(gameWrap.contains(Fbtn)) {
        F_btn.addEventListener('click', () => {
            if (F_position < 30) {
                F_position++;
                F_character.style.left = (F_position * 1) + "%"; // 변수 사용
                console.log("F_character.style.left 후 :: " + F_character.style.right);
                if (F_position === 30) {
                    sendPosition(F_position, "F", "Win_F");
                    document.getElementById("F_heart").style.display = "flex";
                    WinnerOkDialog.textContent = " 여자친구분이 이겼어요.";
                } else {
                    sendPosition(F_position, "F", "NotWinner");
                }
            }

            attendanceModal.show();
        });
    }
});

modalConfirmBtn.addEventListener('click', () => {
    attendanceModal.hide();
})

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

    myWishBtn.addEventListener("click", () => {
        if (myWishText.value !== "") {
            myWishController.classList.add("hidden");
            // sendWish(myWishText.value,partnerWishText.value);
            sendWish(myWishText.value);
        }

    });

    // partnerWishBtn.addEventListener("click", () => {
    //     if (partnerWishText.value !== "") {
    //         partnerWishController.classList.add("hidden");
    //         sendWish(partnerWishText.value,myWishText.value);
    //     }
    // });
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

const sendWish = (mission) => {
    alert("새로고침후 소원 반영 됩니다.");
    fetch('/Game/Wish', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: new URLSearchParams({
            'mission': mission,
        }).toString()
    })
        .then(response => {
            response.text();
            document.getElementById("myMission").innerText = data.mission;
            console.log("mission :: " + response);
            console.log("mission :: " + response.text());
        })
        .catch(error => {
            console.error('Error:', error);
        });
};