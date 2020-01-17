var list = document.getElementById('progress'),
    next = document.getElementById('next'),
    clear = document.getElementById('clear'),
    children = list.children;

//For section equal
var ps = document.getElementById('progress');
var ns = document.getElementById('notice-section');
ns.style.height = ps.clientHeight ;



// simulate activating a node

function stepsCompleted(completed) {
    
    completed = completed*2 - 1

    // count the number of completed nodes.
    if (completed > children.length) return;
    
    // for each node that is completed, reflect the status
    // and show a green color!
    for (var i = 0; i < completed; i++) {
        children[i].children[0].classList.remove('grey');
        children[i].children[0].classList.add('green');

        // if this child is a node and not divider, 
        // make it shine a little more
        if (i % 2 === 0) {
            children[i].children[0].classList.add('activated');
            
            var a = children[i].getElementsByTagName('a')[0];
            a.innerHTML = ' Done ';
            a.style.color = "#4CAF50";
        }
    }

    if (completed < children.length-1) {
        var a = children[completed+1].getElementsByTagName('a')[0];
        a.style.pointerEvents = 'visible';
        a.style.color = '#2432af';
        a.style.textDecoration = 'underline';
    }
    
}

Filevalidation = () => { 
    const fi = document.querySelector('.file'); 
    // Check if any file is selected. 
    if (fi.files.length > 0) { 
        for (const i = 0; i <= fi.files.length - 1; i++) { 

            const fsize = fi.files.item(i).size; 
            const file = Math.round((fsize / 1024)); 
            // The size of the file. 
            if (file >= 4096) { 
                alert( 
                  "File too Big, please select a file less than 4mb"); 
            } else if (file < 2048) { 
                alert( 
                  "File too small, please select a file greater than 2mb"); 
            } else { 
                document.getElementById('size').innerHTML = '<b>'
                + file + '</b> KB'; 
            } 
        } 
    } 
}

Filevalidationphoto = () => { 
    const fi = document.getElementById('photo'); 
    // Check if any file is selected. 
    if (fi.files.length > 0) { 
        for (const i = 0; i <= fi.files.length - 1; i++) { 

            const fsize = fi.files.item(i).size; 
            const file = Math.round((fsize / 1024)); 
            // The size of the file. 
            if (file >= 4096) { 
                alert( 
                  "File too Big, please select a file less than 4 MB"); 
            } else if (file < 2048) { 
                alert( 
                  "File too small, please select a file greater than 2 MB"); 
            } else { 
                document.getElementById('size').innerHTML = '<b>'
                + file + '</b> KB'; 
            } 
        } 
    } 
} 

Filevalidationsign = () => { 
    const fi = document.getElementById('signature'); 
    // Check if any file is selected. 
    if (fi.files.length > 0) { 
        for (const i = 0; i <= fi.files.length - 1; i++) { 

            const fsize = fi.files.item(i).size; 
            const file = Math.round((fsize / 1024)); 
            // The size of the file. 
            if (file >= 4096) { 
                alert( 
                  "File too Big, please select a file less than 4 MB"); 
            } else if (file < 2048) { 
                alert( 
                  "File too small, please select a file greater than 2"); 
            } else { 
                document.getElementById('size').innerHTML = '<b>'
                + file + '</b> KB'; 
            } 
        } 
    } 
}

stepsCompleted(4);