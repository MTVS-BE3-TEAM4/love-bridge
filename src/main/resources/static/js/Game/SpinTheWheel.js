// 돌림판 게임 관련 자바스크립트 코드

let numberOfBetItems = 4;

const $c = document.querySelector("canvas");
const ctx = $c.getContext("2d");

// 룰렛에 들어갈 항목
const betItems = ["aa", "bb"
];

// 각 항목에 해당하는 색상
const colors = [
  "#F89E97", "#F0A84A", "#F7D24A", "#B4DA66",
    "#9FC2E7", "#C2A0DA", "#B4E0E8", "#F3F3F3"
];

function updateNumberDisplay() {
    document.getElementById('number').textContent = numberOfBetItems;
}

// 증가 버튼 클릭 이벤트 리스너
document.getElementById('increment').addEventListener('click', () => {
    if (numberOfBetItems < 8) {
        numberOfBetItems++;
        updateNumberDisplay();
    }
});

// 감소 버튼 클릭 이벤트 리스너
document.getElementById('decrement').addEventListener('click', () => {
    if (numberOfBetItems > 2) {
        numberOfBetItems--;
        updateNumberDisplay();
    }
});

const newMake = () => {
    const [cw, ch] = [$c.width / 2, $c.height / 2];
    const arc = Math.PI / (betItems.length / 2);

    // 돌림판 배경
    for (let i = 0; i < betItems.length; i++) {
      ctx.beginPath();
      ctx.fillStyle = colors[i % colors.length];
      ctx.moveTo(cw, ch);
      ctx.arc(cw, ch, cw, arc * (i - 1), arc * i);
      ctx.fill();
      ctx.closePath();
    }

    ctx.fillStyle = "#fff";
    ctx.font = "18px Pretendard";
    ctx.textAlign = "center";

    for (let i = 0; i < betItems.length; i++) {
      const angle = (arc * i) + (arc / 2);

      ctx.save()  ;

      ctx.translate(
        cw + Math.cos(angle) * (cw - 50),
        ch + Math.sin(angle) * (ch - 50),
      );

      // ctx.rotate(angle + Math.PI / 2);

      betItems[i].split(" ").forEach((text, j) => {
        ctx.fillText(text, 0, 30 * j);
      });

      ctx.restore();
    }
}

function generateWheel() {
    const optionCount = numberOfBetItems;
    const optionInputsContainer = document.getElementById('optionInputs');
    // const wheel = document.getElementById('wheel');
    // const status = document.querySelector('.status');

    console.log(optionCount);

    optionInputsContainer.innerHTML = '';
    // wheel.innerHTML = '';
    // status.textContent = '0 options selected';

    for (let i = 0; i < optionCount; i++) {
        const input = document.createElement('input');
        input.type = 'text';
        input.placeholder = `Option ${i + 1}`;
        input.id = `optionInput${i}`;
        optionInputsContainer.appendChild(input);
    }

    const submitButton = document.createElement('button');
    submitButton.textContent = 'Submit Options';
    submitButton.onclick = () => {
        for (let i = 0; i < optionCount; i++) {
            const optionValue = document.getElementById(`optionInput${i}`).value;
            if (optionValue.trim() === '') {
                alert('All options must be filled out');
                return;
            }
            betItems.push(optionValue);
        }
    };
    optionInputsContainer.appendChild(submitButton);
}

const rotate = () => {
  $c.style.transform = `initial`;
  $c.style.transition = `initial`;
  
  setTimeout(() => {
    
    const ran = Math.floor(Math.random() * betItems.length);

    const arc = 360 / betItems.length;
    const rotate = (ran * arc) + 3600 + (arc * 2);
    
    $c.style.transform = `rotate(-${rotate}deg)`;
    $c.style.transition = `2s`;
    
    setTimeout(() => alert(`${betItems[ran]} 선택되었습니다.`), 2000);
  }, 1);
};

newMake();