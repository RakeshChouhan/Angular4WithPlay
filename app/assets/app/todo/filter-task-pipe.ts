import {Pipe, PipeTransform } from "@angular/core";

/**
 * Filter content based on the flag passed
 */

@Pipe({ name:"filtertask"})
export class FilterTask implements PipeTransform{
    transform(value: any, args: string[]): any {
        let resultData:any = value;
       
        if(args){
            resultData= value.filter((data)=>{return data.completed ===true});
        }else{
            resultData= value.filter((data)=>{return data.completed ===false});
        }
        
        return resultData;
    }

}