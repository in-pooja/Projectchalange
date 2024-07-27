// //write a program to store 
// // let icecream=["vanila","choclate","butterscotch"];
// // for(let i of icecream){
// //     console.log(i);
// // }
// //for an array with marks of student 98,77,55,65,88 find the average marks of the intire class
// let a=[98,77,55,65,88];
// let sum=0;
// for(let i=0;i<=a.length-1;i++){
//    sum+=a[i];
   
// }
// // let ave=sum/a.length;
// length
// console.log(ave)
// document.write(ave)
//--------------------------********************************************************************-------------------------------------------------
// let ic=["vanila","choclate","butterscotch"];
// let vi=ic.push("chococ");
// // document.write(ic);
// // let deletic=ic.push();
// // document.write(deletic);
// console.log(ic);
// console.log(ic.toString());
//----------------------------*****************************************************************************--------------------------------------
//  let a=["riya","tiya","priya"];
//  let b=["be","ca","kb"];
//  let c=["CA","BA","TA"];
//  let result=a.concat(b,c);
//  console.log(result);
//-----------------------------************************************************************************-----------------------------------------
// let a=["ram","krishna","Arjun"];
// a.unshift("shive");
// console.log(a);
//-------------------------------****************************************************************************----------------------------------
// let a=["pooja","pawar","krishna"];
// console.log(a.shift())
// console.log(a);
//---------------------------------******************************************************************************---------------------
// let a=["pooja","pawar","krishna","rajveer"];
// console.lo
//----------------------------------************************************************************************************for-of----------------------------------------
// let str="Apnacollege";
// for(let i of str){
//     document.write(i);
// }
//------------------------------------------------------------************************for-in*******************************88------------------------------------
// let student={
//     name:"pooja",
//     diparment:"Soc",
//     cgpa:76.5,

// };
// // for(let i in student){
// //     document.write(student[i]);
// // }


// console.log(`student name is ${student.name} and cgpa ${student.cgpa}`);
//question5
// let srt="the quick brown box";
// let str2=srt.split(" ");
// for(let i=0;i<str2.length;i++){
//     str2[i]=str2[i].charAt(0).toUpperCase()+str2[i].slice(1);
// }
// let res=str2.join(" ");
// console.log(res);

// let srt = "pooja pawar";
// let str2 = srt.split(" ");
// for (let i = 0; i < str2.length; i++) {
//     str2[i] = str2[i].charAt(0).toUpperCase() + str2[i].slice(1);
// }
// let res = str2.join(" ");
// console.log(res);
//-------------------------------------------------------------------------------------------------------------------
//question66. Write a JavaScript function that accepts a string as a parameter and finds
// the longest word within the string.
// Example string : &#39;Web Development Tutorial&#39;
// Expected Output : &#39;Development&#39;
//  let str="Dev Development Tutorial";
// let str2=str.split(" ");
// let max=0;
// let inmax=0;
// let count=0;
// for(let i=0;i<str2.length;i++){
//    count=str2[i].length;
//    if(count>max){
//    max=count;
//     inmax=i;
//    }
// }
 //console.log(str2[inmax]);
// let str = "Dev Development Tutorial";
// let str2 = str.split(" ");
// let max = 0;
// let inmax = 0;
// let count = 0;
// for (let i = 0; i < str2.length; i++) {
//    count = str2[i].length;
//    if (count > max) {
//       max = count;
//       inmax = i;
//    }
// }
// console.log(str2[inmax]);
//question7. Write a JavaScript function that accepts a string as a parameter and counts
// the number of vowels within the string.
// Note : As the letter &#39;y&#39; can be regarded as both a vowel and a consonant, we
// do not count &#39;y&#39; as vowel here.
// let str="the queck browen box";
// let count=0;
// for(let i=0;i<str.length;i++){
//     if(str[i]=='a'||str[i]=='i'||str[i]=='o'||str[i]=='e'||str[i]=='u'){
//         count++;
//     }
// }
// console.log(count);
// 9. Write a JavaScript function that accepts an argument and returns the type.
// Note : There are six possible values that typeof returns: object, boolean,
// function, number, string, and undefined.
// let a=prompt("enter the number");
// myfunction(a);
// function myfunction(val){
//     console.log(typeof val);
// }
//11. Write a JavaScript function that takes an array of numbers and finds the
// second lowest and second greatest numbers, respectively.
// Sample array : [1,2,3,4,5]
// Expected Output : 2,4
// let n=5;
// let arr=[];
// for(let i=0;i<n;i++){
//     arr[i]=parseInt(prompt("enter the arrya"));
// }
// document.write(arr);
// arr.sort(function(a,b){
//   return a-b;
// })
// let secondlargest=arr[1];

// let secondlowest=arr[arr.length-2];
// document.write("<br> secondlargest  "  +secondlowest);
// document.write("<br> semcodlowest   "  +secondlargest); 