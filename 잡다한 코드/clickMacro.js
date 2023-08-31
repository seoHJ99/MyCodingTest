// 누르고 싶은 버튼
let btn = document.getElementsByName("menu1")[0];

function printTime(date) {
  let hour = date.getHours();
  let min = date.getMinutes();
  let sec = date.getSeconds();
  let mily = date.getMilliseconds();
  if (("" + min).length == 1) {
    min = "0" + min;
  }
  if (("" + sec).length == 1) {
    sec = "0" + sec;
  }
  if (("" + mily).length == 1) {
    sec = "00" + sec;
  } else if (("" + mily).length == 2) {
    sec = "0" + sec;
  }
  return "" + hour + min + sec + mily;
}

function clickBtn() {
  console.log(document.getElementById("NetFunnel_Skin_Top"));

  if (printTime(new Date()) >= "65958600") {
    console.log("!!");
    // console.log(document.getElementById("time_area").innerText);
    // console.log(document.getElementById("msec_area").innerText);
    btn.click();
  }
}

let interval = setInterval(() => {
  clickBtn();
  if (document.getElementById("NetFunnel_Skin_Top") != null) {
    clearInterval(interval);
  }
}, 10);
