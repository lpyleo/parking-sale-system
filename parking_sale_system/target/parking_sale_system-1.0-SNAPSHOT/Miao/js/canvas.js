(function() {
    var tool = 'huabi';
    var size = 10; // 橡皮大小 
    var sub = $('.sub');
    var flag = false;
    var shape = 'rect'; // 橡皮形状

    $('.container').onclick = function(event) {
        var id = event.target.id;
        switch(id) {
            case 'huabi':
                tool = 'huabi';
                flag = false;
                break;
            case 'shuazi':
                tool = 'shuazi';
                flag = false;
                break;
            case 'penqiang':
                tool = 'penqiang';
                flag = false;
                break;
            case 'xiangpi':
                tool = 'xiangpi';
                flag = true;
                break;
        }
        if (flag) {
            sub.style.display = 'block';
        } else {
            sub.style.display = 'none';
        }
    }

    $('select').onchange = function() {
        shape = this.value;
    }

    $('.size').oninput = function() {
        size = this.value;
    }

    var x,y;
    var canvas = $('canvas');
    var ctx = canvas.getContext("2d");

    canvas.onmousedown = function(event) {
        x = event.clientX - this.offsetLeft;
        y = event.clientY - this.offsetTop;

        document.onmousemove = function(event) {
            var x1 = event.clientX - canvas.offsetLeft;
            var y1 = event.clientY - canvas.offsetTop;
            switch(tool) {
                case 'huabi':
                    huabi(x, y, x1, y1, ctx);
                    break;
                case 'shuazi':
                    shuazi(x, y, x1, y1, ctx);
                    break;
                case 'penqiang':
                    penqiang(x, y, ctx);
                    break;
                case 'xiangpi':
                    xiangpi(x, y, x1, y1, ctx, size, shape);
                    break;
            }
            x = x1;
            y = y1;
        }
    }



    document.onmouseup = function() {
        this.onmousemove = null;
    }

})();

function $(selector) {
    return document.querySelector(selector);
}

function uploadFiles(){
    var myFile;
    var canvas = $('canvas');
    var ctx = canvas.getContext("2d");

    myFile = canvas.toDataURL("image/png");
    // alert(myFile);
    var form=document.getElementById("file");
    //使用ajax提交form表单
    var uploadFile = new FormData(form);
    let blob= dataURLtoFile(myFile, 'image/jpeg')
    let fileOfBlob = new File([blob], new Date()+'.jpg')
    uploadFile.append('file', fileOfBlob);
        $.ajax({
            url: '${pageContext.request.contextPath}/user/sign',
            type: 'POST',
            data: uploadFile,
            async: false,
            cache: true,
            contentType: false, //不设置内容类型
            processData: false, //不处理数据
            error: function () {
                alert("上传失败！");
            }
        });

}

function huabi(startX, startY, endX, endY, ctx) {
    ctx.beginPath();
    ctx.globalAlpha = 1;
    ctx.lineWidth = 2;
    ctx.strokeStyle = "#000";
    ctx.moveTo(startX, startY);
    ctx.lineTo(endX, endY);
    ctx.closePath();
    ctx.stroke();
}

function shuazi(startX, startY, endX, endY, ctx) {
    ctx.beginPath();
    ctx.globalAlpha = 1;
    ctx.lineWidth = 10;
    ctx.strokeStyle = "#000";
    ctx.moveTo(startX, startY);
    ctx.lineTo(endX, endY);
    ctx.closePath();
    ctx.stroke();
}

function penqiang(startX, startY, ctx) {
    for(var i = 0; i < 10; i++){
        var randomNum = Math.random()*15;
        ctx.fillStyle = '#000';
        ctx.beginPath();
        ctx.globalAlpha = 0.5;
        ctx.arc(startX + randomNum, startY + randomNum, 1, 0, 2 * Math.PI);
        ctx.fill();
    }
}

function xiangpi(startX, startY, endX, endY, ctx, size, shape) {
    ctx.beginPath();
    ctx.globalAlpha = 1;
    switch(shape) {
        case 'rect':
            ctx.lineWidth = size;
            ctx.strokeStyle = "#fff";
            ctx.moveTo(startX, startY);
            ctx.lineTo(endX, endY);
            ctx.closePath();
            ctx.stroke();
            break;
        case 'circle':
            // ctx.fillStyle = "#fff";
            ctx.arc(startX, startY, size, 0, 2 * Math.PI);
            ctx.fill();
            break;
    }
}

//将base64转换为文件
function dataURLtoFile(dataURI, type) {
    let binary = atob(dataURI.split(',')[1]);
    let array = [];
    for(let i = 0; i < binary.length; i++) {
        array.push(binary.charCodeAt(i));
    }
    return new Blob([new Uint8Array(array)], {type:type });
}


