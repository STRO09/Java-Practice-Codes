class HorizontalSandGlass {

public static void main(String a[]) {

for(int i=1;i<=3;i++){
for(int j=1;j<=5;j++) {
if(j<=i ||i+j>=6) {
System.out.print("*");
}
else {
System.out.print(" ");
}
}
System.out.println();
}

for(int i=4;i<6;i++){
for(int j=1;j<=5;j++) {
if(i+j<7){
System.out.print("*");
}
else {
if(j>=i){
System.out.print("*");
}
else {
System.out.print(" ");
}
}
}
System.out.println();
}

}
}