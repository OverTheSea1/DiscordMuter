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
    /**
     * This is the method where the program starts.
     */
    public static void main(String[] args)
    {
    
        //We construct a builder for a BOT account. If we wanted to use a CLIENT account
        // we would use AccountType.CLIENT
        try
        {
            JDA jda = (JDA) new JDABuilder("NzY1MTk1NDQ1NzAxODM2ODUw.X4RRyg.exU2_7kxOLjr0Ckz0cbpuMHokS4")         // The token of the account that is logging in.
                    .addEventListeners(new JavaBOT())  // An instance of a class that will handle events.
                    .setActivity(Activity.playing("AmongUs"))
                    .setStatus(OnlineStatus.ONLINE)
                   
                    .build();
            jda.awaitReady(); // Blocking guarantees that JDA will be completely loaded.
            
            
            
        }
        catch (LoginException e)
        {
            //If anything goes wrong in terms of authentication, this is the exception that will represent it
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            //Due to the fact that awaitReady is a blocking method, one which waits until JDA is fully loaded,
            // the waiting can be interrupted. This is the exception that would fire in that situation.
            //As a note: in this extremely simplified example this will never occur. In fact, this will never occur unless
            // you use awaitReady in a thread that has the possibility of being interrupted (async thread usage and interrupts)
            e.printStackTrace();
        }
    }


	private String X;

   
    @SuppressWarnings("null")
	@Override
    public void onMessageReceived(MessageReceivedEvent event) 
    {
        //These are provided with every event in JDA
        JDA jda = event.getJDA();                       //JDA, the core of the api.
        long responseNumber = event.getResponseNumber();//The amount of discord events that JDA has received since the last reconnect.

        //Event specific information
        User author = event.getAuthor();                //The user that sent the message
        Message message = event.getMessage();           //The message that was received.
        MessageChannel channel = event.getChannel();    //This is the MessageChannel that the message was sent to.
                                                        //  This could be a TextChannel, PrivateChannel, or Group!

        String msg1 = message.getContentDisplay();              //This returns a human readable version of the Message. Similar to
        String msg = msg1.toLowerCase();                             // what you would see in the client.

        boolean bot = author.isBot();                    //This boolean is useful to determine if the User that
                                                        // sent the Message is a BOT or not!

        if (event.isFromType(ChannelType.TEXT))         //If this message was sent to a Guild TextChannel
        {
            //Because we now know that this message was sent in a Guild, we can do guild specific things
            // Note, if you don't check the ChannelType before using these methods, they might return null due
            // the message possibly not being from a Guild!

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
    		if(wuerfel.nextInt(5)==1) {
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
    		if(wuerfel.nextInt(5)==1) {
    			channel.sendMessage("Hier findest du den Bot, OpenSource auf GitHub: https://github.com/OverTheSea1/DiscordMuter").queue();
    		}
        		}catch (Exception e) {
        			channel.sendMessage("Du bist in keinem Sprachkanal").queue();
        		}
     
       
       
       
        		}
        	      }
    				}
        	
  						// Grüße aus DE Ba-Wü
