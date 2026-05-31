import { Plus } from "lucide-react";

export default function Header({ onCreate }: { onCreate: () => void }) {
  return (
    <div className="flex justify-between items-center mb-4">
      {/* <div>
        <h2 className="text-xl font-semibold">Tugas AI</h2>
        <p className="text-xs text-gray-400">
          Jadwalkan AI kirim otomatis ke WhatsApp
        </p>
      </div> */}

      <button
        onClick={onCreate}
        className="bg-orange-500 hover:bg-orange-600 text-xs px-3 py-2 rounded-md flex items-center gap-1"
      >
        <Plus size={14} />
        Buat Tugas
      </button>
    </div>
  );
}