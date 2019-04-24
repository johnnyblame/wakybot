 import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
 import org.telegram.telegrambots.meta.api.objects.Update;
 import org.telegram.telegrambots.bots.TelegramLongPollingBot;
 import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
 
 import java.io.*;
 import java.util.*;


 public class wakybot extends TelegramLongPollingBot {
 
	 

	@Override
	
	
    public void onUpdateReceived(Update update)  {
    	String message_text = update.getMessage().getText();
        long chat_id = update.getMessage().getChatId();
        String path1 = "/home/johnnyblame/eclipse-workspace/wakybot/test1.txt";
        String path2 = "/home/johnnyblame/eclipse-workspace/wakybot/test2.txt";
        String path3 = "/home/johnnyblame/eclipse-workspace/wakybot/test3.txt";
        if (update.hasMessage() && update.getMessage().hasText()) {
   
        if(message_text.equals("Віка") | message_text.equals("Vika")) {
        	SendMessage message = new SendMessage()
            		.setChatId(chat_id)
                    .setText("Moya defka");
            		

        	try {
        		execute(message);
        	} catch (TelegramApiException e) {
        		e.printStackTrace();
        	}
        }else if(message_text.equals("/arthas")) {
   

            	try {
        			String messageSend = readfile(path1);
        			
        			SendMessage message = new SendMessage()
                    		.setChatId(chat_id)
                            .setText(messageSend);
                	try {
                		execute(message);
                		
                	} catch (TelegramApiException e) {
                		e.printStackTrace();
                	}

        		} catch (FileNotFoundException e1) {
        			e1.printStackTrace();
        		}
            } else if(message_text.equals("/illidan")) {
            	try {
        			String messageSend = readfile(path2);
        			
        			SendMessage message = new SendMessage()
                    		.setChatId(chat_id)
                            .setText(messageSend);
                	try {
                		execute(message);
                		
                	} catch (TelegramApiException e) {
                		e.printStackTrace();
                	}

        		} catch (FileNotFoundException e1) {
        			e1.printStackTrace();
        		}
            } else if(message_text.equals("/thrall")) {
            	try {
        			String messageSend = readfile(path3);
        			
        			SendMessage message = new SendMessage()
                    		.setChatId(chat_id)
                            .setText(messageSend);
                	try {
                		execute(message);
                		
                	} catch (TelegramApiException e) {
                		e.printStackTrace();
                	}

        		} catch (FileNotFoundException e1) {
        			e1.printStackTrace();
        		}
            } else if(message_text.equals("/commands")) {
            	
        			String messageSend = "Hello. I am replying with quotes of Warcraft characters. For now '/arthas', '/illidan' and '/thrall' are available.";
        			
        			SendMessage message = new SendMessage()
                    		.setChatId(chat_id)
                            .setText(messageSend);
                	try {
                		execute(message);
                		
                	} catch (TelegramApiException e) {
                		e.printStackTrace();
                	}

        		 
            }
        }
    	
       
    	
        
    }
    
    
    

    @Override
    public String getBotUsername() {
        return "wakybot";
    }

    @Override
    public String getBotToken() {
        return "769264816:AAE-ksyAvn8L_ZzebhfunREKXa9Pc49wvJg";
    }
    
    public static String readfile(String path) throws FileNotFoundException {
        Map<String,Integer> map = new HashMap<String,Integer>();
		String s = choose(new File(path));

        for(int i = 0; i < 1; ++i)
        {
           if(!map.containsKey(s))
              map.put(s, 0);
           map.put(s, map.get(s)+1);
           }
		return s;
		
		}
 
     public static String choose(File f) throws FileNotFoundException
     {
        String result = null;
        Random rand = new Random();
        int n = 0;
        for(Scanner sc = new Scanner(f); sc.hasNext(); )
        {
           ++n;
           String line = sc.nextLine();
           if(rand.nextInt(n) == 0)
              result = line;         
        }

        return result;      
     }
}
