package com.sgk.compose_sdui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.sgk.compose_sdui.ui.widgets.constraint_layout.commonConstrainsHandling


fun TwoContraintSet(
    childConstraintModel1: com.sgk.model.modal.ChildConstraintModel,
    childConstraintModel2: com.sgk.model.modal.ChildConstraintModel,
) : ConstraintSet{
    return ConstraintSet {
//        val button = createRefFor("button")
        val ref1 = createRefFor(childConstraintModel1.refId)
//        val text = createRefFor("text")
        val ref2 = createRefFor(childConstraintModel2.refId)


        val list : List<ConstrainedLayoutReference> = listOf(
            ref1,
            ref2
        )

        constrain(ref1) {
//            constraintSetModel1.top?.let {
//                top.linkTo(
//                    list.getReferenceBasedOnId(
//                        constraintSetModel1.top.constraintComposableId
//                    ).top,
//                    margin = constraintSetModel1.top.margin.dp
//                )
//            }

            commonConstrainsHandling(
                list = list,
                childConstraintModel = childConstraintModel1
            )

            commonConstrainsHandling(
                list = list,
                childConstraintModel = childConstraintModel2
            )


        }
        constrain(ref1) {
            top.linkTo(ref2.top)
        }
    }
}


private fun decoupledConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val button = createRefFor("button")
        val text = createRefFor("text")


        constrain(button) {
            top.linkTo(parent.top, margin = margin)
        }
        constrain(text) {
            top.linkTo(button.bottom, margin)
        }
    }
}

@Preview
@Composable
fun columnTesting(){



    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {


        val (topBox,bottomBox,list) = createRefs()

        ConstraintLayout (
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Color.Red)
                .constrainAs(topBox) {
                    top.linkTo(parent.top)
                }
        ){


        }

        LazyColumn(
            modifier = Modifier
                .constrainAs(list) {
                    top.linkTo(topBox.bottom)
                    bottom.linkTo(bottomBox.top)
                    height = Dimension.fillToConstraints

                }
        ) {

            for( i in 1..10){
                item {
                    listItem(number = i.toString())
                }
            }

        }

        Box (
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Color.Blue)
                .constrainAs(bottomBox) {
                    bottom.linkTo(parent.bottom)
                }

        ){

        }


    }
}

@Composable
fun listItem(
    number : String
){

    Card(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(16.dp)
            .height(100.dp),
    ) {



    }

}