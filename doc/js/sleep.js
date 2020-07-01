
function sleep1(d){
    for(let t = Date.now();Date.now() - t <= d;){}
}

function sleep2 (time) {
    return new Promise((resolve) => setTimeout(resolve, time));
}


function main(){

    sleep1(500);

    sleep2(500).then(() => {

    });
}

