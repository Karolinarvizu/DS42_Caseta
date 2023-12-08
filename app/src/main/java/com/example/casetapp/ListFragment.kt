package com.example.casetapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

    private var casetas : MutableList<Caseta> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val fab = view.findViewById<FloatingActionButton>(R.id.fab_new)
        initData()
        val adapter = CasetaAdapter(casetas)

        val recyclerView =
            view.findViewById<RecyclerView>(
                R.id.casetasRecycler
            )



        //Variables para el elemento nuevo
        var _id : Int = 0
        var _tipo : String
        var _matricula : String
        var _tarifa : String
        var _icono: String
        var _image : String

        fab.setOnClickListener {


            // Show Bottom Sheet Dialog and add a new item
            val bottomSheetFragment = BottomSheetDialog(view.context)
            val parentView : View = layoutInflater.inflate(R.layout.bsd_new_caseta, null)
            bottomSheetFragment.setContentView(parentView)
            bottomSheetFragment.show()

            //elementos del formulario bsd
            val newId = parentView.findViewById<EditText>(R.id.bsd_caseta_id)
            val newTipo = parentView.findViewById<EditText>(R.id.bsd_caseta_tipo)
            val newMatricula = parentView.findViewById<EditText>(R.id.bsd_caseta_matricula)
            val newIcono = parentView.findViewById<EditText>(R.id.bsd_caseta_icono)
            val newImage = parentView.findViewById<EditText>(R.id.bsd_caseta_image)
            val newTarifa = parentView.findViewById<EditText>(R.id.bsd_caseta_tarifa)

            val button = parentView.findViewById<Button>(R.id.bsd_submit)

            //boton guardar del bsd, asignación de valores y creación del nuevo elemento
            button.setOnClickListener{
                _id = newId.text.toString().toInt()
                _tipo = newTipo.text.toString()
                _matricula = newMatricula.text.toString()
                _icono = newIcono.text.toString()
                _image = newImage.text.toString()
                _tarifa = newTarifa.text.toString()

                val newProductAdd = Caseta(
                    _id,
                    _tipo,
                    _matricula,
                    _tarifa,
                    _icono,
                    _image,

                )

                casetas.add(newProductAdd)

                recyclerView.adapter?.notifyDataSetChanged()

                bottomSheetFragment.dismiss()
            }
        }

        //Lista anchura completa
        val layoutManager = LinearLayoutManager(container?.context)
        //Cuadricula 2X2
        //val gridLayoutManager = GridLayoutManager(container?.context, 2)

        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter

        return view
    }

    private fun initData() {

        casetas = mutableListOf(
            Caseta(1, "Auto", "656554", "84$", "drawable/carro.png","https://www.autonocion.com/wp-content/uploads/2020/11/Prueba-Mercedes-AMG-A-45-S-4MATIC-2020-28.jpg"),
            Caseta(2, "Moto", "546845", "42$", "drawable/moto.png","https://static.retail.autofact.cl/blog/c_url_original.57j61kfr22ckf.jpg"),
            Caseta(3,"Autobus","687897","137$", "drawable/autobus.jpg", "https://1.bp.blogspot.com/-GVzPWTS3BuA/XwliwJ0zTzI/AAAAAAAAa70/1o3hP3XUfnsAqLV-CqMCz5edGNyQeIINACLcBGAsYHQ/s1600/IMG_5219.JPG"),
            Caseta(4, "Camion", "878897", "200$", "drawable/camion.jpg", "https://th.bing.com/th/id/R.972cdf62b1ed9f756757b2d443affe22?rik=jW6oGPAa8KroAQ&riu=http%3a%2f%2ffiles.123inventatuweb.com%2f16%2f08%2f160833a1-386b-4f30-a76c-c34c191a0320.jpg&ehk=QQ4yEbkQyHnT1i18Qiu2JU2BInbHNcH0ysqSECvZ%2bxo%3d&risl=&pid=ImgRaw&r=0&sres=1&sresct=1"),
            Caseta(5, "Auto", "694515", "84$", "drawable/carro.png","https://www.autonocion.com/wp-content/uploads/2020/08/Prueba-Peugeot-e-2008-Allure-2020-8.jpg"),
            Caseta(6,"Autobus","544564","137$", "drawable/autobus.jpg", "https://4.bp.blogspot.com/-zX5aVB0GyWc/XDi5TTPeXVI/AAAAAAAAVXo/9OXjJ-c8aB45AqfbCdhdAibT15urrTGMwCLcBGAs/s1600/SAM_0022.JPG"),
            Caseta(7, "Moto", "894565", "42$", "drawable/moto.png","https://static.retail.autofact.cl/blog/c_url_original.57j61kfr1qrkh.jpg"),
            Caseta(8, "Camion", "895987", "200$", "drawable/camion.jpg", "https://th.bing.com/th/id/R.05e7876e42aef31ecd11662df6f48a68?rik=jaNQZaoaTcl65g&riu=http%3a%2f%2f2.bp.blogspot.com%2f-LNSXTcEpHoc%2fVfwmiGa7pvI%2fAAAAAAAAE-g%2f8KqQxtYOy-U%2fs1600%2fCami%2525C3%2525B3n-MAN_1295_127775.jpg&ehk=kTxPoyyaFsSrDhIs7j07Km326PLiNclqYXnwZz2ZwRQ%3d&risl=&pid=ImgRaw&r=0"),
            Caseta(9, "Auto", "546457", "84$", "drawable/carro.png","https://dicas.olx.com.br/wp-content/uploads/2021/04/carro-perua-sw-palio-weekend-1.png"),
            Caseta(10, "Auto", "898854", "84$", "drawable/carro.png","https://www.comparaonline.com.co/blog-statics/co/uploads/2019/08/tipos-de-veh%C3%ADculos-hatchback.jpg"),
        )
    }
}