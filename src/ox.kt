val table = arrayOf(
    arrayOf(' ', '1', '2', '3'),
    arrayOf('1', '-', '-', '-'),
    arrayOf('2', '-', '-', '-'),
    arrayOf('3', '-', '-', '-')
)
var turn = 0
var player = 'x'

fun printTurn(){
    if(turn % 2 == 0){
        player = 'x'
        println("$player turn")
    }else{
        player = 'o'
        println("$player turn")
    }
}

fun printTable(){
    for(row in table){
        for(col in row){
            print("$col")
        }
        println()
    }
}

fun checkWin() : Boolean{
    for(i in table.indices){
        if(table[i][1] == table[i][2] && table[i][2] == table[i][3] && !table[i].contains('-')){
            return true
        }
        if(table[1][i] == table[2][i] && table[2][i] == table[3][i] && table[3][i]!='-'){
            return true
        }
        if(table[1][1] == table[2][2] && table[2][2] == table[3][3] && table[2][2]!='-'){
            return true
        }
        if(table[1][3] == table[2][2] && table[2][2] == table[3][1] && table[2][2]!='-'){
            return true
        }
    }
    return false
}

fun input(){

}

fun main() {
    while(true) {
        printTable()
        printTurn()

        print("Please input Row Col :")
        val input = readLine()
        //println(input)
        val rcList = input?.split(" ")
        if(rcList?.size != 2){
            println("Error : please input again")
            continue
        }
        val rowInd = rcList[0].toInt()
        val colInd = rcList[1].toInt()
        //println("Row : $rowInd Col : $colInd")

        if(rowInd > 0 && rowInd < 4 && colInd > 0 && colInd < 4) {
            if(table[colInd][rowInd] == '-'){
                table[colInd][rowInd] = player
                if(checkWin()){
                    println("${player.toUpperCase()} Win!!")
                    break
                }
                if(turn == 8){
                    println("Draw!!")
                    break
                }
            }
            else{
                println("Error!! : not empty please input again")
                continue
            }
        }else{
            println("Error!! : please input again")
            continue
        }

        turn++
    }
}