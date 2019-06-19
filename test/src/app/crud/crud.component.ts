import { Component, OnInit, ViewChild } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-crud',
  templateUrl: './crud.component.html',
  styleUrls: ['./crud.component.css']
})
export class CrudComponent implements OnInit {

  receiveddata: any[];
  keys: any;
  values: any;
  
    constructor(private dataService: DataService) {
    this.dataService.shareDataSubject.subscribe(receiveddata => {
      this.receiveddata = receiveddata;
      this.xmlData(receiveddata);
    });
  }

  xmlData(receiveddata) {
   
    this.receiveddata = JSON.parse(receiveddata);
    this.keys = Object.keys(this.receiveddata);
    this.values = Object.values(this.receiveddata);
    console.log(this.values.tagName);
    //console.log(typeof(this.values));
    console.log(Object.values(this.values));
    console.log(this.receiveddata);
    console.log(this.receiveddata);
    //console.log(this.keys[0]);
    //console.log(typeof(this.keys));
  
  }

  ngOnInit() {

  }
Save(item, i){
var newvalue = document.getElementById('value'+i).innerText;
console.log(newvalue);
this.values[i].tagValue= newvalue;

}
Delete(item, i){
  var random = document.getElementById('value'+i).innerText;
  if(!i){
    alert("You can not delete root element!")
  }
  else if (window.confirm("Do you want to delete: " + random)) {
    this.values.splice(i, 1);
    this.keys.splice(i,1);
    //this.Xpath.splice(i,1);
  } 
}

Add(item, i){
  var random = document.getElementById('value'+i).innerText;
  if(!i && !random)
  {alert("You can not add a root element. Only one root element allowed!")}
  else {
    var newtagName = document.getElementById('name'+i).innerText.concat("1");
    var newxpath = document.getElementById('xpath'+i).innerText.concat("1");
    this.values.splice(i+1,0,newtagName);
    this.keys.splice(i+1,0,newxpath);
    this.values.splice(i+1,0,"");
  }
}
  /* Save(item) {
    console.log()
     var index = this.Customers.Employees.Employee.indexOf(item);
     var firstname = document.getElementById('firstname'+index).innerText;
     var nickname = document.getElementById('nickname' + index).innerText;
     var salary = document.getElementById('salary' + index).innerText;
     var lastname = document.getElementById('lastname' + index).innerText;
     item.firstname = firstname;
     item.nickname = nickname;
     item.salary = salary;
     item.lastname = lastname;
     this.Customers.Employees.Employee[index] = item; 
 }
 
 Delete(item) {
    var index = this.Customers.Employees.Employee.indexOf(item);
   var firstname = this.Customers.Employees.Employee[index].firstname;
   if (window.confirm("Do you want to delete: " + firstname)) {
     this.Customers.Employees.Employee.splice(index, 1);
   } 
 }
 
 Add(item) {
   
   this.Customers.Employees.Employee.push(this.newitem);
   this.newitem = {};
 } */
}
