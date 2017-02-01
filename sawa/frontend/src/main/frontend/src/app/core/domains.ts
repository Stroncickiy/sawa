export interface User {
  id:string|number;
  email:string;
  name?:string;
  userStats?:UserStats;
  isMyself?:boolean;
}