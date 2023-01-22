package kg.geektech.counter51

class Presenter {
    val model = Model()
    lateinit var  view: View

    fun increment(){
        model.increment()
        view.changedCount(model.count)
    }
    fun attachView(view: View){
        this.view = view
    }
    fun showT(){
        if (model.count ==10){
            view.showToast()
        }

    }
    fun changeColor(){
        if (model.count ==15){
            view.changeColor()
        }
    }

}