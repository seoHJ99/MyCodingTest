function hanoi(count, from, to, temp ){
    if(count == 0) return;
    
    hanoi(count-1, from, temp, to);
    // 움직일수 있는 기둥 2개, from에서 temp로 이동하는 것이 목적
    // 그래야 목표 기둥이 비어있게 되고 따라서 가장 아래 원반을 c로 이동 가능
    console.log(`원반 ${count}를 ${from}에서 ${to}로 이동`);
    hanoi(count -1, temp, to, from);
}

hanoi(3, "A", "C", "B"); // 원반 3개. 기둥 A(시작),B,C(목표) ;
