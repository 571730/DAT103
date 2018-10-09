; Konstanter
	cr equ 13 ; Vognretur
	lf equ 10 ; Linjeskift
	SYS_EXIT equ 1
	SYS_WRITE equ 4
	STDIN equ 0
	STDOUT equ 1
	STDERR equ 2
	
section .bss
    a resb 1
    
section .data
    crlf db cr,lf
	crlflen equ $ - crlf

    
section .text

global _start
_start:
    mov [a], byte 0
    mov ecx,[a]
    mov edx,0
    call Lokke
    
    
Lokke:
    mov eax,20
    mov ebx,10
    cmp edx,ebx
    jb IncrementBoth
    cmp edx,eax
    jb IncrementIdecreaseA ;Etter dette skal lokken vaere ferdig
    add ecx, '0'
    mov [a],ecx
    mov ecx,a
    mov edx,1
	mov ebx,STDOUT
	mov eax,SYS_WRITE
	int 80h
	mov edx,crlflen ;Linjeskift
	mov ecx,crlf
	mov ebx,STDOUT
	mov eax,SYS_WRITE
	int 80h
    
Slutt:
    mov eax,SYS_EXIT
	mov ebx,0
	int 80h
    
IncrementBoth:
    push eax
    mov eax,1
    add ecx,eax
    add edx,eax
    pop eax
    call Lokke
    
IncrementIdecreaseA:
    push eax
    mov eax,1
    add edx,eax
    sub ecx,eax
    pop eax
    call Lokke

