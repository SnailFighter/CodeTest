import tkinter as tk

window = tk.Tk()
window.title('my window')
window.geometry('200x100')

on_hit = False 
def hit_me():
    global on_hit
    if on_hit == False:     
        on_hit = True
        var.set('you hit me')  
    else:      
        on_hit = False
        var.set('') 

var = tk.StringVar()  
l = tk.Label(window, 
    textvariable=var,  
    bg='green', font=('Arial', 12), width=15, height=2)
l.pack()    

b = tk.Button(window, 
    text='hit me',     
    width=15, height=2, 
    command=hit_me)    
b.pack()  



window.mainloop()