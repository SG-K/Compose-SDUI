package com.sgk.foodapphomepagesdui.ui.widgets.constraint_layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

//@Composable
//@Preview
//fun sampleConstraintLayout(){
//    ConstraintLayout(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color.Green)
//            .padding(20.dp)
//    ) {
//        val ( text, image) = createRefs()
//
//        Text(
//            text = "Password",
//            modifier = Modifier
//                .background(Color.Red)
//                .constrainAs(text){
//                    top.linkTo(parent.top)
//                    start.linkTo(parent.start)
//                    end.linkTo(image.start)
//                    width = Dimension.fillToConstraints
//                },
//            textAlign = TextAlign.Left
//        )
//
//        Image(
//            imageVector = Icons.Default.Edit,
//            contentDescription = "Edit",
//            modifier = Modifier
//                .constrainAs(image){
//                    top.linkTo(parent.top)
//                    end.linkTo(parent.end)
//                }
//        )
//    }
//}


@Composable
@Preview
fun sampleConstraintLayout(){

    val constraintSet = ConstraintSet {
        val text = createRefFor("text")
        val image = createRefFor("image")

        constrain(text){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(image.start)
            width = Dimension.fillToConstraints
        }

        constrain(image){
            top.linkTo(parent.top)
            end.linkTo(parent.end)
        }

    }


    ConstraintLayout(
        constraintSet = constraintSet,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green)
            .padding(20.dp)
    ) {

        Text(
            text = "Password",
            modifier = Modifier
                .background(Color.Red)
                .layoutId("text"),
//                .constrainAs(text){
//                    top.linkTo(parent.top)
//                    start.linkTo(parent.start)
//                    end.linkTo(image.start)
//                    width = Dimension.fillToConstraints
//                },
            textAlign = TextAlign.Left
        )

        Image(
            imageVector = Icons.Default.Edit,
            contentDescription = "Edit",
            modifier = Modifier
                .layoutId("image")
//                .constrainAs(image){
//                    top.linkTo(parent.top)
//                    end.linkTo(parent.end)
//                }
        )
    }
}