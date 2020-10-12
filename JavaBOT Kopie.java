package de.packag;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.PermissionException;
import net.dv8tion.jda.api.exceptions.RateLimitedException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;

import javax.security.auth.login.LoginException;
import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class JavaBOT extends ListenerAdapter
{
   
    public static void main(String[] args)
    {
    
      
        try
        {
            JDA jda = (JDA) new JDABuilder("TOKEN")         // The token of the account that is logging in.
                    .addEventListeners(new JavaBOT())  
                    .setActivity(Activity.playing("AmongUs"))
                    .setStatus(OnlineStatus.ONLINE)
                   
                    .build();
            jda.awaitReady();
            
            
            
        }
        catch (LoginException e)
        {
           
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            
            e.printStackTrace();
        }
    }


	private String X;

   
    @SuppressWarnings("null")
	@Override
    public void onMessageReceived(MessageReceivedEvent event) 
    {
        
        JDA jda = event.getJDA();                       
        long responseNumber = event.getResponseNumber();

       
        User author = event.getAuthor();                
        Message message = event.getMessage();           
        MessageChannel channel = event.getChannel();  
                                                      

        String msg1 = message.getContentDisplay();           
        String msg = msg1.toLowerCase();                             

        boolean bot = author.isBot();                 
                                                      

        if (event.isFromType(ChannelType.TEXT))         
        {
           

            Guild guild = event.getGuild();             
            TextChannel textChannel = event.getTextChannel();
            Member member = event.getMember();         

            String name;
            if (message.isWebhookMessage())
            {
                name = author.getName();  
                User user = member.getUser();	
            }                                        
            else
            {
                name = member.getEffectiveName();       

            System.out.printf("(%s)[%s]<%s>: %s\n", guild.getName(), textChannel.getName(), name, msg);
        }
       
    
       
        
      
        
        
        
        
       
        	
        	if(msg.equals(".mute")) {
        		try {
        		List<Member> el = event.getMember().getVoiceState().getChannel().getMembers();
        		int i = 0;
        		for(i=0; i < el.size(); i++) {
        			el.get(i).mute(true).complete();
        			
        		}
        		
        	channel.sendMessage("Der Sprachkanal ist nun stummgeschalten").queue();
        		}catch (Exception e) {
        			channel.sendMessage("Du bist in keinem Sprachkanal").queue();
        		}
       
        	
        }else if(msg.equals(".unmute")) {
        	try {
        		List<Member> el = event.getMember().getVoiceState().getChannel().getMembers();
        		int i = 0;
        		for(i=0; i < el.size(); i++) {
        			el.get(i).mute(false).complete();
        			
        		}
        		
        	channel.sendMessage("Der Sprachkanal ist nun wieder laut geschaltet").queue();
        		}catch (Exception e) {
        			channel.sendMessage("Du bist in keinem Sprachkanal").queue();
        		}
        }
       
       
       
        		}}
        	//Grüße aus DE Ba-Wü
  
