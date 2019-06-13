import { Component, OnInit } from '@angular/core';
import { FileUploader, FileSelectDirective } from 'ng2-file-upload/ng2-file-upload';
import { templateJitUrl } from '@angular/compiler';
import { Template } from '@angular/compiler/src/render3/r3_ast';
import { DataService } from './data.service';
//import { DataService } from "../data.service";

const URL = 'http://localhost:8009/getxml';

@Component({
  selector: 'app-upload',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {

  //To share response

  response: any;
  // constructor(private data: DataService) { }
  constructor(private dataService: DataService) { }

  public uploader: FileUploader = new FileUploader({ url: URL, itemAlias: 'file' });

  ngOnInit() {

    //this.data.currentMessage.subscribe(message => this.message = message);

    this.uploader.onAfterAddingFile = (file) => { file.withCredentials = false; };
    this.uploader.onCompleteItem = (item: any, response: any, status: any, headers: any) => {
/*       console.log('XMLUploaded:uploaded:', item, status, response);
 */      this.passData(response);
      alert('File uploaded successfully');


      //sending data to service
      //this.data.changeMessage(response);
    }
  }
  passData(responseXml) {
    this.dataService.sendDataToOtherComponent(responseXml);
  }

}