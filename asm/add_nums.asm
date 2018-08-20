.model small
.stack 100h
.data
prompt1 db 13, 10, 'First number','$'
prompt2 db 13, 10, 'Second number','$'
result db 13, 10, 'input number','$'

;Variables

num1 dw ?
num2 dw ?
sum dw ? 

.code 
main proc

	mov ax,@data	;get data segment address
	mov ds,ax		;initialize ds

;Display prompt

	mov ah,9			;print string function
	mov dx,offset prompt1   ;ds:dx points to string
	int 21h

; Numbers from the user
 	mov ah,1 	;input function
 	int 21h
 	mov bl,al 	;save the value from input
	mov num1,bl

	mov ah,9
	lea dx, prompt2		 ;print prompt
	int 21h

	mov ah,2 	;input second function
 	int 21h
 	mov bh,al 	;save the value from second input
	mov num2,bh

;Addition
		sub num1,'0'
		sub num2,'0'
		mov ax,num1			;move num1 into ax
		add ax,num2			;add first and second numbers together
		mov sum,ax			 ;move the total sum of numbers in sum
		add sum,'0'


;Print Sum
	mov ah,9
	lea dx, result		 ; print result
	int 21h

	mov ah,2 
	mov dl,bl
	int 21h

	mov dl,'+'			 ;display + sign
	int 21h

	mov dl,bh
	int 21h


	mov dl,'='			 ;display = sign
	int 21h

	mov dl,bh
	int 21h


	mov ah,4ch
	int 21h

   main endp

end main