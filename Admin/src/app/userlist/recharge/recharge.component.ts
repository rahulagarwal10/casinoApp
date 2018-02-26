import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-recharge',
  templateUrl: './recharge.component.html',
  styleUrls: ['./recharge.component.css']
})
export class RechargeComponent implements OnInit {

  @Output() closebox=new EventEmitter()
  @Output() recharge=new EventEmitter<number>()
  constructor() { }

  ngOnInit() {
  }

  close(){
    this.closebox.emit();
  }

  rechargeAmount(amount){
    if(amount==null){
      amount=0;
    }
    this.recharge.emit(amount);
  }


}
