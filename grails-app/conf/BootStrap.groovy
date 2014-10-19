import com.goldragriff.wetalk.MessageGroup
import com.goldragriff.wetalk.User

class BootStrap {

    def init = { servletContext ->
        def todd = new User(name: 'Todd', phoneNumber: '859', shortName: 'Todd').save()
        def dorks = new MessageGroup(name: 'Dorks', members: [todd]).save()

    }
    def destroy = {
    }
}
