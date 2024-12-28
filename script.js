// Ricardo Hernandez
// 12/27/2024

// Variables
let wordsFromLyrics = [];
let uniqueWords = [];
let lyricFile = null;
let lyricsText = null;

const fileSelector = document.getElementById('file-selector');
fileSelector.addEventListener('change', (event) => {
    const fileList = event.target.files;
	lyricFile = fileList[0];
  });

const startButton = document.getElementById('start-button');
const reader = new FileReader();

const content = document.getElementById('content');
const uniqueContent = document.getElementById('unique-content');


// Gets text file with the lyrics
function getLyricsFile() {
	//find lyrics.txt
	
	
	reader.addEventListener(
		"load",
		() => {
			// this will then display a text file
			content.innerText = reader.result;
			console.log(reader.result);
			getUniqueWords(reader.result);
		},
		false,
	);

	if (lyricFile) {
		reader.readAsText(lyricFile);
	}

}

//
function getUniqueWords(l) {
	// Start with the first word in the file
	// add to uniqueWords
	//forEach(let word in uniqueWords) {
	l = l.replace(/\n/g, '');
	l = l.replace(/\r/g, ' ');
	l = l.replace(',', '');
	l = l.replace('-', '');
	wordsFromLyrics = l.split(' ');
	console.log(wordsFromLyrics);
	
	wordsFromLyrics.forEach((word) => {
		if(!uniqueWords.includes(word)) {
			if(word != ' ' || word != '') {
				uniqueWords.push(word);
			}
		} else {	// REPEAT WORD DETECTED 
			console.log("can't add " + word); 
			
		}			
		
	})
	
	uniqueContent.innerText = "Your song has " + uniqueWords.length + " unique words\nand " + wordsFromLyrics.length + " total words!";
	tableCreate();
	
}

function tableCreate() {
  var e = document.getElementById('table-area');
  var tbl = document.createElement('table');
  tbl.style.width = '600px';
  tbl.setAttribute('border', '1');
  var tbdy = document.createElement('tbody');
  for (var i = 0; i < wordsFromLyrics.length; i++) {
    var tr = document.createElement('tr');
	
	
    for (var j = 0; j < wordsFromLyrics.length; j++) {
      
        var td = document.createElement('td');
        td.appendChild(document.createTextNode('\u0020'))
		
		if (i == j || wordsFromLyrics[i] == wordsFromLyrics[j]) {
			td.classList.add('bg');
		}
		
        tr.appendChild(td)
		
      
    }
    tbdy.appendChild(tr);
  }
  tbl.appendChild(tbdy);
  e.appendChild(tbl)
}

// Event Listeners
startButton.addEventListener('click', getLyricsFile);