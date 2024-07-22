// 돌림판 게임 관련 자바스크립트 코드
/*
    1. 아이템 숫자 지정
    2. 숫자에 따라 인풋텍스트 생성 (원형으로 배치하는 방법은?)
    3. 텍스트가 모두 입려되면 설정 버튼 클릭
    4. 돌리기 버튼
    5. 결과 (숫자에 따라 각도 조절 계산식 어떻게?)
    6. 한 번 돌리고 다시 돌리려면 각도 리셋
 */

const canvas = document.querySelector("canvas");
const ctx = canvas.getContext("2d");

// 각 항목에 해당하는 색상
const colors = [
    "#F89E97", "#F0A84A", "#F7D24A", "#B4DA66",
    "#9FC2E7", "#C2A0DA", "#B4E0E8", "#F3F3F3"
];

// 룰렛에 들어갈 항목
let betItems = [];

// 항목 수가 먼저 정해지므로 변수 추가함
let numberOfBetItems = 4;

const clearCanvas = () => {
    canvas.style.transform = `initial`;
    canvas.style.transition = `initial`;
    ctx.clearRect(0, 0, canvas.width, canvas.height);
};

// 돌림판과 문자입력 창 그리기
function updateNumberDisplay() {
    document.getElementById('number').textContent = numberOfBetItems;
    generateInputText()
    makeWheel()
}

// 증가 버튼 클릭 이벤트 리스너
document.getElementById('increment').addEventListener('click', () => {
    if (numberOfBetItems < 8 && window.getComputedStyle(document.getElementById("rotateButton")).display === "none") {
        numberOfBetItems++;
        updateNumberDisplay();
    }
});

// 감소 버튼 클릭 이벤트 리스너
document.getElementById('decrement').addEventListener('click', () => {
    if (numberOfBetItems > 2 && window.getComputedStyle(document.getElementById("rotateButton")).display === "none") {
        numberOfBetItems--;
        updateNumberDisplay();
    }
});

// 설정완료 버튼 동작, 돌림판에 그렸던 텍스트들을 지우고 새로 입력된 내용 반영함.
const setInputBetItems = () => {
    betItems = [];
    for (let i = 0; i < numberOfBetItems; i++) {
        const optionValue = document.getElementById(`optionInput${i}`).value;
        if (optionValue.trim() === '') {
            alert('모든 옵션을 입력해주세요.');
            return;
        }
        betItems.push(optionValue);
    }
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    makeWheel();
    changeShowButton();
}

//재설정하기 버튼 동작
const reset = () => {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    changeShowButton();
    betItems = []
    makeWheel();
}

const changeShowButton = () => {
    const setInputBetItemsButton = document.getElementById("setInputBetItemsButton")
    const optionInputs = document.getElementById("optionInputs");
    const rotateButton = document.getElementById("rotateButton");
    const resetButton = document.getElementById("resetButton");

    const currentRotateButton = window.getComputedStyle(rotateButton).display;
    if (currentRotateButton === "none") {
        setInputBetItemsButton.style.display = "none";
        optionInputs.style.display = "none";
        rotateButton.style.display = "block";
        resetButton.style.display = "block";
    } else {
        setInputBetItemsButton.style.display = "block";
        optionInputs.style.display = "block";
        rotateButton.style.display = "none";
        resetButton.style.display = "none";
    }
}

const rotate = () => {
    clearCanvas()
    makeWheel();
    setTimeout(() => {

        const ran = Math.floor(Math.random() * betItems.length);
        const arc = 360 / betItems.length;
        const rotate = (ran * arc) + 1800 + 95 + Math.floor(Math.random() * (arc - 5));
        console.log(arc, rotate, ran);

        canvas.style.transform = `rotate(-${rotate}deg)`;
        canvas.style.transition = `2s`;

        setTimeout(() => alert(`${betItems[ran]} 선택되었습니다.`), 2000);
    }, 700);
};

// numberOfBetItems 숫자에 따라 텍스트 입력창 생성
function generateInputText() {
    const optionCount = numberOfBetItems;
    const optionInputsContainer = document.getElementById('optionInputs');
    optionInputsContainer.innerHTML = '';

    for (let i = 0; i < optionCount; i++) {
        const input = document.createElement('input');
        input.type = 'text';
        input.placeholder = `Option ${i + 1}`;
        input.id = `optionInput${i}`;
        optionInputsContainer.appendChild(input);
    }
}

// 돌림판 생성
const makeWheel = () => {
    const [cw, ch] = [canvas.width / 2, canvas.height / 2];
    const arc = Math.PI * (2 / numberOfBetItems);

    // 돌림판 배경
    for (let i = 0; i < numberOfBetItems; i++) {
        ctx.beginPath();
        ctx.fillStyle = colors[i % colors.length];
        ctx.moveTo(cw, ch);
        ctx.arc(cw, ch, cw, arc * i, arc * (i + 1));
        ctx.fill();
        ctx.closePath();
    }

    ctx.fillStyle = "#fff";
    ctx.font = "18px Pretendard";
    ctx.textAlign = "center";

    for (let i = 0; i < betItems.length; i++) {
        const angle = (arc * i) + (arc / 2);

        ctx.save();

        ctx.translate(
            cw + Math.cos(angle) * (cw - 50),
            ch + Math.sin(angle) * (ch - 50),
        );

        // 글자 회전, 기획에서 회전시키자고 하면 추가할 예정
        // ctx.rotate(angle + Math.PI / 2);

        betItems[i].split(" ").forEach((text, j) => {
            ctx.fillText(text, 0, 30 * j);
        });

        ctx.restore();
    }
}

updateNumberDisplay();