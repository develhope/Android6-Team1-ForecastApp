package co.develhope.meteoapp.errordialog

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import co.develhope.meteoapp.databinding.FragmentErrorDialogBinding

class ErrorDialogFragment : DialogFragment() {

    private var _binding: FragmentErrorDialogBinding? = null
    private val binding get() = _binding!!

    private var errorDialogListener: ErrorDialogListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ErrorDialogListener) {
            errorDialogListener = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Nasconde la bottom navigation quando viene mostrato il dialog
        errorDialogListener?.hideBottomNavigationView()

        binding.root.setOnClickListener {
            // Chiude il dialogo
            dismiss()
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)

        // Mostra nuovamente la bottom navigation quando il dialogo viene chiuso
        errorDialogListener?.showBottomNavigationView()
    }
}