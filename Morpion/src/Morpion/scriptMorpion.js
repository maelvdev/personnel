const cells = document.querySelectorAll('.cell');
const statusMessage = document.getElementById('status-message');
const resetButton = document.getElementById('reset-button');
const startGameButton = document.getElementById('start-game');
const player1Input = document.getElementById('player1');
const player2Input = document.getElementById('player2');
const gameContainer = document.querySelector('.game-container');
const playerInputsContainer = document.querySelector('.player-inputs');
const icons = document.querySelectorAll('.icon');
const instructionText = document.getElementById('instruction');

let currentPlayer = 'X';
let gameState = ['', '', '', '', '', '', '', '', ''];
let gameActive = true;
let player1Name = '';
let player2Name = '';
let player1Icon = '';
let player2Icon = '';
let iconSelectionStep = 1; // 1 pour joueur 1, 2 pour joueur 2

const winningConditions = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6]
];

icons.forEach(icon => {
    icon.addEventListener('click', function() {
        if (iconSelectionStep === 1) {
            player1Icon = this.getAttribute('data-icon');
            this.classList.add('selected');
            instructionText.innerText = "Joueur 2, choisissez votre icône";
            iconSelectionStep = 2;
        } else if (iconSelectionStep === 2) {
            player2Icon = this.getAttribute('data-icon');
            this.classList.add('selected');
            instructionText.innerText = "";
            startGameButton.style.display = 'inline-block';
        }

        // Désactive l'icône choisie pour l'autre joueur
        this.style.pointerEvents = 'none';
    });
});

function handleCellClick(event) {
    const clickedCell = event.target;
    const clickedCellIndex = clickedCell.getAttribute('data-index');

    // Si la case est déjà occupée ou si le jeu est terminé, on ne fait rien
    if (gameState[clickedCellIndex] !== '' || !gameActive) {
        return;
    }

    // Met à jour l'état de la cellule et l'affiche avec l'icône du joueur courant
    gameState[clickedCellIndex] = currentPlayer;
    clickedCell.innerHTML = `<img src="${currentPlayer === 'X' ? player1Icon : player2Icon}" alt="Icône">`;

    // Vérifie s'il y a un gagnant
    checkForWinner();
}

function checkForWinner() {
    let roundWon = false;
    
    for (let i = 0; i < winningConditions.length; i++) {
        const [a, b, c] = winningConditions[i];
        if (gameState[a] !== '' && gameState[a] === gameState[b] && gameState[a] === gameState[c]) {
            roundWon = true;
            break;
        }
    }

    if (roundWon) {
        const winnerName = currentPlayer === 'X' ? player1Name : player2Name;
        statusMessage.innerText = `${winnerName} a gagné !`;
        gameActive = false;
        return;
    }

    if (!gameState.includes('')) {
        statusMessage.innerText = "Match nul !";
        gameActive = false;
        return;
    }

    // Change le joueur courant pour le tour suivant
    currentPlayer = currentPlayer === 'X' ? 'O' : 'X';
    const currentPlayerName = currentPlayer === 'X' ? player1Name : player2Name;
    statusMessage.innerText = `C'est au tour de ${currentPlayerName}`;
}

function resetGame() {
    currentPlayer = 'X';
    gameState = ['', '', '', '', '', '', '', '', ''];
    gameActive = true;
    const currentPlayerName = currentPlayer === 'X' ? player1Name : player2Name;
    statusMessage.innerText = `C'est au tour de ${currentPlayerName}`;
    cells.forEach(cell => (cell.innerHTML = ''));
}

function startGame() {
    player1Name = player1Input.value || 'Joueur 1';
    player2Name = player2Input.value || 'Joueur 2';

    if (!player1Icon || !player2Icon) {
        alert("Chaque joueur doit choisir une icône.");
        return;
    }

    playerInputsContainer.style.display = 'none';
    gameContainer.style.display = 'block';
    statusMessage.innerText = `C'est au tour de ${player1Name}`;
}

cells.forEach(cell => cell.addEventListener('click', handleCellClick));
resetButton.addEventListener('click', resetGame);
startGameButton.addEventListener('click', startGame);
