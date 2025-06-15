/*The structure of the node of the queue is
class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}*/

class MyQueue
{
    QueueNode front, rear;
    
    //Function to push an element into the queue.
	void push(int a)
	{
        // Your code here
        if(rear == null){
            rear = new QueueNode(a);
            front = rear;
            
        }
        else{
            QueueNode temp = new QueueNode(a);
            rear.next = temp ; 
            rear = rear.next;
            
        }
	}
	
    //Function to pop front element from the queue.
	int pop()
	{
        // Your code here
        
        if(front == null){
            return -1;
        }
        if(front == rear ){
           
            int val = front.data;
            front = null;
            rear = null;
            return val;
        }
        else{
            int val = front.data;
            front = front.next ;
            return val;
        }
	}
}




