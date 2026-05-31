export default function HistoryModal({ open, onClose, data }: any) {
  if (!open) return null;

  return (
    <div className="fixed inset-0 bg-black/60 flex justify-center items-center">
      <div className="bg-[#111] p-4 rounded-lg w-96 text-sm">
        <h2 className="mb-3 font-semibold">Riwayat</h2>

        <div className="space-y-2 max-h-60 overflow-auto">
          {data.map((item: any, i: number) => (
            <div key={i} className="bg-[#222] p-2 rounded">
              {item.status} - {item.runAt}
            </div>
          ))}
        </div>

        <button
          className="mt-3 text-orange-400"
          onClick={onClose}
        >
          Tutup
        </button>
      </div>
    </div>
  );
}