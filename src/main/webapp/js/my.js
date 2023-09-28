$.fn.typewriter = function (params) {
    function writer(elem, text, speed, repeat) {
        var i = 0,
            TextNode = document.createTextNode("");
        elem.appendChild(TextNode);
        elem.timer = setInterval(function () {
            if (text.length === i) repeat ? (i = 0, TextNode.data = "") : clearInterval(elem.timer);
            else
                for (TextNode.data += text[i++];" " === text[i];) TextNode.data += text[i++]
        }, speed)
    }
    var options = {
        speed: 30,
        repeat: false
    }, options = $.extend(options, params);
    return this.each(function () {
        var text = $(this).text();
        $(this).text("");
        writer(this, text, options.speed, options.repeat)
    })
};

$(window).load(function(){
    $(".typing").typewriter();
});


function sendForm(){
    const myForm = document.getElementById('startButton');
    myForm.click();
}