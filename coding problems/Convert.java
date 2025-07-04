class Convert {


public static void main(String args[]){

String str="eeebheleeebeeb";
String sub="eeb";
int count=0;

for(int i=0;i<str.length();i++){
int matchedletters=0;
for(int j=0;j<sub.length();j++){
if(str.charAt(i+j)==sub.charAt(j)){
matchedletters++;
}
else{
break;
}

}

if(matchedletters==sub.length()){
count++;
}

}

if(count>0) {
System.out.println("Substring exists in the string"+count+"times");
}
else {
System.out.println("Substring does not exist in string");
}


}
}