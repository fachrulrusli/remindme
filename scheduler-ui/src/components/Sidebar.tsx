import { LayoutDashboard, MessageSquare, FileText } from "lucide-react";

export default function Sidebar() {
  return (
    <div className="w-60 bg-[#0d0d0d] border-r border-gray-800 p-4 text-sm">
      <h2 className="text-sm font-semibold mb-6">AI Scheduler</h2>

      <nav className="space-y-2">
        <Item icon={<LayoutDashboard size={16} />} label="Tugas AI" active />
      </nav>
    </div>
  );
}

function Item({ icon, label, active = false }: any) {
  return (
    <div
      className={`flex items-center gap-2 px-3 py-2 rounded-md cursor-pointer ${
        active ? "bg-orange-500/20 text-orange-400" : "hover:bg-[#1a1a1a]"
      }`}
    >
      {icon}
      {label}
    </div>
  );
}