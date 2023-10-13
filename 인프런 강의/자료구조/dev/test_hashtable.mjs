import { HashTable } from "./HashTable.mjs";

let hashTable = new HashTable();

hashTable.set(1, "이운재");
hashTable.set(4, "최진철");
hashTable.set(20, "홍명보");
hashTable.set(6, "유상철");
hashTable.set(14, "이천수");
hashTable.set(10, "이영표");
hashTable.set(21, "박지성");


console.log(`1" ${hashTable.get(1)}`);
hashTable.remove(1);
console.log(`1" ${hashTable.get(1)}`);
console.log(`1" ${hashTable.get(21)}`);