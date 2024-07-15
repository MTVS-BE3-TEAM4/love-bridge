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

const sendPosition = (position, gender, winner) => {
    fetch('/Game/MoveGame', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: `cnt=${position}&gender=${gender}&winner=${winner}`
    })
        .then(response => response.text())
        .then(data => {
            console.log(data);
        })
        .catch(error => {
            console.error('Error:', error);
        });
};


// 여자
document.getElementById("F_btn").addEventListener("click", function() {
    if (F_position <= 29) {
        F_position++;
        F_character.style.left = (F_position * 21) + "px";
        sendPosition(F_position, "F","NotWinner");
    } else if (F_position >= 30) {
        sendPosition(F_position,"F","Win_F");
        alert("F is win")
    }
});

// 남자
document.getElementById("M_btn").addEventListener("click", function() {
    if (M_position <= 29) {
        M_position++;
        M_character.style.right = (M_position * 21) + "px";
        sendPosition(M_position, "M","NotWinner");
    } else if (M_position >= 30) {
        sendPosition(M_position,"M","Win_M");
        alert("M is win")
    }
});



