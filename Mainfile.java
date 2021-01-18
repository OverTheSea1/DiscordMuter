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

public class Mainfile.java extends ListenerAdapter
{
    
    public static void main(String[] args)
    {
    
        
        try
        {
            JDA jda = (JDA) new JDABuilder("TOKEN")         
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

        //Event specific information
        User author = event.getAuthor();                
        Message message = event.getMessage();           
        MessageChannel channel = event.getChannel();    
                                                        
        String msg1 = message.getContentDisplay();              
        String msg = msg1.toLowerCase();                             

        boolean bot = author.isBot();                   
                                                       

        if (event.isFromType(ChannelType.TEXT))         
        {
            
            Guild guild = event.getGuild();             //The Guild that this message was sent in. (note, in the API, Guilds are Servers)
            TextChannel textChannel = event.getTextChannel(); //The TextChannel that this message was sent to.
            Member member = event.getMember();          //This Member that sent the message. Contains Guild specific information about the User!

            String name;
            if (message.isWebhookMessage())
            {
                name = author.getName();  
                User user = member.getUser();	//If this is a Webhook message, then there is no Member associated
            }                                           // with the User, thus we default to the author for name.
            else
            {
                name = member.getEffectiveName();       //This will either use the Member's nickname if they have one,
            }                                           // otherwise it will default to their username. (User#getName())

            System.out.printf("(%s)[%s]<%s>: %s\n", guild.getName(), textChannel.getName(), name, msg);
        }
        else if (event.isFromType(ChannelType.PRIVATE)) //If this message was sent to a PrivateChannel
        {
            //The message was sent in a PrivateChannel.
            //In this example we don't directly use the privateChannel, however, be sure, there are uses for it!
            PrivateChannel privateChannel = event.getPrivateChannel();

            System.out.printf("[PRIV]<%s>: %s\n", author.getName(), msg);
        }
    
       
        
      
        
        
        
        
       
        	
        	if(msg.equals(".mute")) {
        		try {
        		List<Member> el = event.getMember().getVoiceState().getChannel().getMembers();
        		int i = 0;
        		for(i=0; i < el.size(); i++) {
        			el.get(i).mute(true).complete();
        			
        		}
        		
        	channel.sendMessage("Der Sprachkanal ist nun stummgeschalten").queue();
        	
        	Random wuerfel = new Random();
    		int augenZahl;
    		if(wuerfel.nextInt(10)==1) {
    			channel.sendMessage("Hier findest du den Bot, OpenSource auf GitHub: https://github.com/OverTheSea1/DiscordMuter").queue();
    		}
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
        	Random wuerfel = new Random();
    		int augenZahl;
    		if(wuerfel.nextInt(10)==1) {
    			channel.sendMessage("Hier findest du den Bot, OpenSource auf GitHub: https://github.com/OverTheSea1/DiscordMuter").queue();
    		}
        		}catch (Exception e) {
        			channel.sendMessage("Du bist in keinem Sprachkanal").queue();
        		}
     
       
       
       
        		}
        	      }
    				}
        	
  						// De
