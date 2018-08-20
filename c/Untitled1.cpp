#include <stdio.h>
main() {
   int LA[] = {1,3,5,7,8, 6, 7, 8, 9, 10, 11, 12 ,13 ,14 ,15 ,16, 27 ,28 ,29, 20};
   int max = 20;
   int i = 0;
   for (i = 0; i < max; i++){
       LA[i] = i * 2;
   }
   
   for (i = 0; i <= max; i++){
       printf("LA[%d] = %d \n", i, LA[i]);
   }
}
