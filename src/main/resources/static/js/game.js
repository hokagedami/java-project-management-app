function decodeHTML(html) {
    const txt = document.createElement('textarea');
    txt.innerHTML = html;
    return txt.value;
}



const questionsString = decodeHTML(questions);
const questionsJson = JSON.parse(questionsString);


let questionCounter = 0;
let quizStarted = false;

const progressBar = document.getElementById("myBar");
const startGame = () => {
    progressBar.style.width = 0 + "%";
    displayQuestion(questionCounter);
    // questionCounter++;
   if(questionCounter < questionsJson.length) {
       let progressBarCounter = 0;
       const interval = setInterval(() => {
           progressBarCounter += 1;
           progressBar.style.width = `${(progressBarCounter / 10) * 100}%`;

           if(progressBarCounter === 10) {
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
const pauseGame = () => {
    console.log("Game paused");
}
const stopGame = () => {
    console.log("Game stopped")
}
const resetGame = () => {
    console.log("Game reset")
}

function displayQuestion(index) {
    if (index >= questionsJson.length) return;
    console.log(`Displaying question: ${index}`);
    const questionBlock = document.getElementById("question-header");
    const answerBlock = document.getElementById("question-options");
    questionBlock.style.display = "block";
    answerBlock.style.display = "block";

    const question = questionsJson[index];
    const questionDiv = document.getElementById("question");
    questionDiv.innerHTML = question["question"];
    const option1Div = document.getElementById("option-1");
    option1Div.innerText = question["options"][0];
    const option2Div = document.getElementById("option-2");
    option2Div.innerText = question["options"][1];
    const option3Div = document.getElementById("option-3");
    option3Div.innerText = question["options"][2];
    const option4Div = document.getElementById("option-4");
    option4Div.innerText = question["options"][3];
}

function displayGameEnd(){
    const answerDiv = document.getElementById("quiz-answers");
    answerDiv.style.display = "none";
    const questionDiv = document.getElementById("question");
    questionDiv.innerHTML = "Game Over!";
}


// Event listener for the start button
document.getElementById('startButton')
    .addEventListener('click', function() {
        if (!quizStarted) {
            quizStarted = true;
            startGame();
        }
});
