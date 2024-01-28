function decodeHTML(html) {
    const txt = document.createElement('textarea');
    txt.innerHTML = html;
    return txt.value;
}



const questionsString = decodeHTML(questions);
const questionsJson = JSON.parse(questionsString);


let questionCounter = 0;
let quizStarted = false;
let quizEnded = false;

const progressBar = document.getElementById("myBar");
const startGame = () => {
    const startButton = document.getElementById("startButton");
    startButton.style.display = "none";
    progressBar.style.width = 0 + "%";
    displayQuestion(questionCounter);
    // questionCounter++;
   if(questionCounter < questionsJson.length) {
       let progressBarCounter = 0;
       const interval = setInterval(() => {
           progressBarCounter += 1;
           progressBar.style.width = `${(progressBarCounter / 5) * 100}%`;

           if(progressBarCounter === 5) {
               clearInterval(interval);
                questionCounter++;
               startGame();
           }
       }, 1000);
   }
   else {
       displayGameEnd();
   }
}

function showAnswers() {
    progressBar.style.width = 0 + "%";
    displayQuestion(questionCounter, true);
    // questionCounter++;
    if(questionCounter < questionsJson.length) {
        let progressBarCounter = 0;
        const interval = setInterval(() => {
            progressBarCounter += 1;
            progressBar.style.width = `${(progressBarCounter / 5) * 100}%`;

            if(progressBarCounter === 5) {
                clearInterval(interval);
                questionCounter++;
                showAnswers();
            }
        }, 1000);
    }
    else {
        displayGameEnd();
    }
}

function displayQuestion(index, withAnswer = false) {
    if (index >= questionsJson.length
        || questionsJson.length < 1) return;
    console.log(`Displaying question: ${index}`);
    const questionBlock = document.getElementById("question-header");
    const answerBlock = document.getElementById("question-options");
    const questionImage = document.getElementById("question-image");
    const progressBar = document.getElementById("myProgress");


    progressBar.style.display = "block";

    const question = questionsJson[index];
    const questionHasImage = question["hasImage"];
    if (questionHasImage) {
        questionImage.src = question["image"];
        questionImage.style.display = "block";
    } else {
        questionImage.style.display = "none";
    }

    questionBlock.style.display = "block";
    const questionDiv = document.getElementById("question");
    questionDiv.innerHTML = question["question"];

    answerBlock.style.display = "block";
    const option1Div = document.getElementById("option-1");
    option1Div.innerText = question["options"][0];
    const option2Div = document.getElementById("option-2");
    option2Div.innerText = question["options"][1];
    const option3Div = document.getElementById("option-3");
    option3Div.innerText = question["options"][2];
    const option4Div = document.getElementById("option-4");
    option4Div.innerText = question["options"][3];

    if (withAnswer) {
        const answerDiv = document.getElementById("answer-bar");
        const answerLine = document.getElementById("answer-line");
        const answerSpan = document.getElementById("answer-span");

        answerDiv.style.display = "block";
        answerLine.style.display = "block";
        answerSpan.innerText = question["answer"];
    }
}

function displayGameEnd(){
    const answerDiv = document.getElementById("quiz-answers");
    answerDiv.style.display = "none";
    const questionDiv = document.getElementById("question");
    questionDiv.innerHTML = "Game Over!";
    const showAnswer = document.getElementById("nextButton");
    showAnswer.style.display = "block";
    quizEnded = true;
    questionCounter = 0;
}



// Event listener for the start button
document.getElementById('startButton')
    .addEventListener('click', function() {
        if (!quizStarted) {
            quizStarted = true;
            startGame();
        }
});

document.getElementById('nextButton')
    .addEventListener('click', function() {
        if (quizEnded) {
            const answerDiv = document.getElementById("quiz-answers");
            answerDiv.style.display = "block";
            showAnswers();
            console.log("Game ended");
        }
    });
