import { Component, OnInit, ViewChild } from '@angular/core';
import { isNull } from 'util';
import { AppComponent } from '../app.component';
import { DataService } from '../data.service';
//import { DataService } from "../data.service";

@Component({
  selector: 'app-crud',
  templateUrl: './crud.component.html',
  styleUrls: ['./crud.component.css']
})
export class CrudComponent implements OnInit {

  recieveddata: any[];
  xml: any;
  keys:any;
  values:any;
  //Customers:string;
  constructor(private dataService: DataService) {
    this.dataService.shareDataSubject.subscribe(receiveddata => {
      this.recieveddata = receiveddata;
      this.xmlData(receiveddata);
    });
  }

  //constructor(private data: DataService) { }

  xmlData(recieveddata)
  {
    this.keys=Array<String>();
    this.values=Array<String>();
   console.log(typeof(recieveddata));
   console.log(recieveddata);
   recieveddata=JSON.parse(recieveddata);
   
   recieveddata.forEach(element => {
    this.keys.push(element.key);
    this.values.push(element.value);
   });
  } 

  ngOnInit() {
   
    //this.data.currentMessage.subscribe(message => this.Customers = message);
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