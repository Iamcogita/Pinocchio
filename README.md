<p align="center">
  <a href=" ">
    <img src="https://i.imgur.com/DJo3D6r.png" height="180px">
  </a>
</p>

Mindera_Events is a rest arquitecture API created with springboot framework made for the Mindswap bootcamp at Mindera.<br>
It manages a mongoDB database of Mindera's Events, using pattern model view controller, relating users to events and managing attendance and waitting lists. It also calls an exernal Api to generate a QR code for each Event.


 ## What it does:
 - Creates Users with jwt authentication
 - Creates events with:
    - Title
    - Type of event
    - Approval state
    - Date
    - Starting time 
    - Attendance slots 
 - Allows for users to add themselves to event attendance list
 - Sends email to users when registered
<p></p>

 ## How it does it:
 - If there are no available slots for users to attend any given event:
    <table>
      public void deleteUserPresence(String idUser, String idEvent) {
        Event event = getEventByEventId(idEvent);
        User user = getUserByUserId(idUser);
        if (event.getAttendance().stream()
                .anyMatch(theUser->theUser.getId().equals(user.getId()))){
            event.getAttendance().removeIf(user1->user1.getId().equals(user.getId()));
            eventRepository.save(event);
            user.getEvents().remove(idEvent);
            userService.updateUser(idUser,user);
            updateWaitingListToAttendance(event);
            return;
        }
        if (event.getWaitingList().stream().anyMatch(theUser->theUser.equals(user))){
            event.getWaitingList().removeIf(user1->user1.getId().equals(user.getId()));
            eventRepository.save(event);
            return;
        }
        throw new UserNotFoundException("The user is not present in that event.");
    }
    </table>
 - that
<p></p>

 ## How it's used:
 - like this
 - like that
<p></p>
 

## Contributors:

<table>
  <tr>
    
  <td align="center"><a href="https://github.com/joaoguima24"><img src="https://avatars.githubusercontent.com/u/108727426?v=4" width="100px;" alt="João Guimarães"/><br /><sub><b>João Guimarães</b></sub></a><br /></td>
    
  <td align="center"><a href="https://github.com/Iamcogita"><img src="https://avatars.githubusercontent.com/u/99983918?v=4" width="100px;" alt="David Mendes"/><br /><sub><b>David Mendes</b></sub></a><br /></td>
    
  <td align="center"><a href="https://github.com/fabioiketani"><img src="https://avatars.githubusercontent.com/u/108727648?v=4" width="100px;" alt="Fabio Iketani"/><br /><sub><b>Fabio Iketani</b></sub></a><br /></td>
    
  <td align="center"><a href="https://github.com/Interetion"><img src="https://avatars.githubusercontent.com/u/104978602?v=4" width="100px;" alt="Carla Pereira"/><br /><sub><b>Carla Pereira</b></sub></a><br /></td>
    
  </tr>
</table>

<h3>THANK YOU FOR READING!</h3>
