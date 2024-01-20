const chartDataStr = decodeHTML(chartData);
const chartJsonArray = JSON.parse(chartDataStr);

const stagesLabelStr = decodeHTML(stagesLabel);
const stagesLabelJson = JSON.parse(stagesLabelStr);

const arrayLength = chartJsonArray.length;
const numericData = [];
const labelData = [];

for (let i = 0; i < arrayLength; i++) {
    numericData[i] = chartJsonArray[i].total;
    labelData[i] = stagesLabelJson[chartJsonArray[i].label];
}

new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [
            {
                label: "Project Statuses",
                backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f"],
                borderColor: '#000000',
                data: numericData
            }
        ]
    },
    options: {
        legend: {display: false},
        title: {
            display: true,
            text: 'Project Statuses'
        }
    }
});

function decodeHTML(html) {
    const txt = document.createElement('textarea');
    txt.innerHTML = html;
    return txt.value;
}